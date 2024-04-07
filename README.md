# Overview
RepoController is a Spring Boot REST controller that is part of a web application designed to fetch popular repositories based on specified criteria. This controller is a key component in interacting with the GitHub API (or similar services) to retrieve repository data.

# Endpoints
The controller defines the following endpoint:
```http
 GET /api/repositories/popular
```
Retrieves a list of popular repositories filtered by the creation date and optionally by programming language.

# Parameters
#### page (Integer, optional): The page number of the repository list (for pagination). Default is 0.
#### size (Integer, optional): The number of repositories to return per page. Default is 10.
#### created-date (String, required): The date from which to fetch popular repositories. The date should be in a format (typically yyyy-MM-dd).
#### language (String, optional): The programming language to filter the repositories. If omitted, repositories of all languages are included.

### Response
RepoResponse: A response object containing the list of popular repositories and any associated metadata.

# Usage
To use this endpoint, make a GET request to /api/repositories/popular with the required and optional query parameters. For example:

```http
GET /api/repositories/popular?created-date=2022-01-01&page=1&size=10&language=Java
```

This request will fetch popular repositories created since January 1, 2022, on the first page, with up to 10 repositories per page, filtered to those written in Java.
