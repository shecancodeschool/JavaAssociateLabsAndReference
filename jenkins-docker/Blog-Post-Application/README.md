# Spring Boot Blog Post Application

This repository contains a Spring Boot-based blog post application that is deployed on AWS App Runner with a fully automated CI/CD pipeline. The application leverages AWS CodePipeline and CodeBuild for continuous integration and deployment, ensuring high availability and easy scalability.

## Features

- **Spring Boot Backend**: Powered by Spring Boot, providing RESTful APIs for blog management.
- **AWS App Runner Hosting**: Automatically builds, deploys, and scales the application.
- **CI/CD with AWS CodePipeline**: Automated deployment pipeline triggered by code changes.
- **Build Automation with AWS CodeBuild**: Compiles, tests, and packages the application.

## Architecture Overview

1. **Source Code Management**: Code changes pushed to the main branch trigger the pipeline.
2. **CodePipeline**: Manages the CI/CD workflow, from build to deployment.
3. **CodeBuild**: Runs the build and test stages to verify application functionality.
4. **App Runner**: Deploys and scales the application automatically based on traffic.
