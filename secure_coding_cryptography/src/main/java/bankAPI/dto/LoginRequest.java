package bankAPI.dto;

public record LoginRequest(
        String username,
        String password
) {
}
