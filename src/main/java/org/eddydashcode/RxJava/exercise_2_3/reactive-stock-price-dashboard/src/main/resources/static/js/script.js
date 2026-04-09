document.addEventListener('DOMContentLoaded', function () {
    const socket = new WebSocket(`/ws/stocks`);
    const stocksContainer = document.getElementById('stocks-container');
    const tickerInput = document.getElementById('ticker-select');
    const subscribeBtn = document.getElementById('subscribe-btn');

    // Track active subscriptions
    const activeSubscriptions = new Set();

    // Handle WebSocket connection
    socket.addEventListener('open', (event) => {
        console.log('WebSocket connected');

    });

    // Handle incoming messages
    socket.addEventListener('message', (event) => {
        try {
            const data = JSON.parse(event.data);
            if (data.message.trim() === "HTTP 429") {
                throw new Error("Rate limit exceeded. Please try again later.");
            }

            // updateStockCard(data);
        } catch (error) {

            const newData = {
                symbol: "AAPL",
                askPrice: 1234,
                bidPrice: 444,
                volume: 3333,
                lastUpdated: 1244555,
                lastSalePrice: 334444
            }
            updateStockCard(newData)
        }
    });

    // Handle errors
    socket.addEventListener('error', (event) => {
        console.error('WebSocket error:', event);
    });

    // Handle disconnection
    socket.addEventListener('close', (event) => {
        console.log('WebSocket disconnected:', event.code, event.reason);
    });

    // Subscribe to new ticker
    subscribeBtn.addEventListener('click', () => {
        const ticker = tickerInput.value.trim().toUpperCase();
        if (ticker && !activeSubscriptions.has(ticker)) {
            socket.send(ticker);
            activeSubscriptions.add(ticker);
            tickerInput.value = '';
        }
    });

    // Allow Enter key to subscribe
    tickerInput.addEventListener('keypress', (e) => {
        if (e.key === 'Enter') {
            subscribeBtn.click();
        }
    });

    // Update or create stock card
    function updateStockCard(quote) {
        let card = document.getElementById(`stock-${quote.symbol}`);
        console.log(quote)
        if (!card) {
            card = document.createElement('div');
            card.className = 'stock-card';
            card.id = `stock-${quote.symbol}`;
            card.innerHTML = `
                        <h3>${quote.symbol}</h3>
                        <div class="price" id="price-${quote.symbol}">${quote.askPrice}</div>
                        <div class="change" id="change-${quote.symbol}">${quote.bidPrice}</div>
                        <div class="volume">Volume: ${quote.volume}</div>
                        <div class="last-updated" id="updated-${quote.symbol}">${quote.lastUpdated}</div>
                        <button class="unsubscribe-btn" data-ticker="${quote.symbol}">Unsubscribe</button>
                    `;
            stocksContainer.appendChild(card);

            // Add unsubscribe handler
            card.querySelector('.unsubscribe-btn').addEventListener('click', (e) => {
                const ticker = e.target.getAttribute('data-ticker');
                activeSubscriptions.delete(ticker);
                card.remove();
            });
        }

        // Update price
        const priceElement = document.getElementById(`price-${quote.symbol}`);
        const previousPrice = parseFloat(priceElement.textContent.replace('$', ''));
        const currentPrice = quote.lastSalePrice;

        priceElement.textContent = `$${currentPrice.toFixed(2)}`;

        // Highlight price change
        priceElement.className = 'price';
        if (previousPrice && currentPrice > previousPrice) {
            priceElement.classList.add('price-up');
        } else if (previousPrice && currentPrice < previousPrice) {
            priceElement.classList.add('price-down');
        }

        // Update change
        const changeElement = document.getElementById(`change-${quote.symbol}`);
        if (quote.bidPrice && quote.askPrice) {
            const spread = (quote.askPrice - quote.bidPrice).toFixed(2);
            changeElement.textContent = `Spread: $${spread}`;
        }

        // Update last updated time
        const updatedElement = document.getElementById(`updated-${quote.symbol}`);
        if (quote.lastUpdated) {
            const date = new Date(quote.lastUpdated);
            updatedElement.textContent = `Updated: ${date.toLocaleTimeString()}`;
        }
    }
});