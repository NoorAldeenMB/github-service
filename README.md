# Github-Service

Overview
RepoController is a Spring Boot REST controller that is part of a web application designed to fetch popular repositories based on specified criteria. This controller is a key component in interacting with the GitHub API (or similar services) to retrieve repository data.

Endpoints
The controller defines the following endpoint:

GET /api/repositories/popular
Retrieves a list of popular repositories filtered by the creation date and optionally by programming language.

Parameters
page (Integer, optional): The page number of the repository list (for pagination). Default is 0.
size (Integer, optional): The number of repositories to return per page. Default is 10.
creating-date (String, required): The date from which to fetch popular repositories. The date should be in a format recognized by the backend (typically yyyy-MM-dd).
language (String, optional): The programming language to filter the repositories. If omitted, repositories of all languages are included.
Response
RepoResponse: A response object containing the list of popular repositories and any associated metadata.
Usage
To use this endpoint, make a GET request to /api/repositories/popular with the required and optional query parameters. For example:

sql
Copy code
GET /api/repositories/popular?creating-date=2022-01-01&page=1&size=10&language=Java
This request will fetch popular repositories created since January 1, 2022, on the first page, with up to 10 repositories per page, filtered to those written in Java.

Error Handling
The RepoController is equipped to handle various types of input and server errors:

If the creating-date parameter is missing or empty, a 400 Bad Request response is returned with an appropriate error message.
In the case of server errors or issues with external dependencies, appropriate HTTP status codes (like 503 Service Unavailable) are returned.
Dependencies
RepoService: This service is responsible for the business logic associated with fetching repository data. RepoController relies on this service to process requests.
Validation
Request parameters are validated for presence and format. @Validated annotation at the class level ensures that request parameters adhere to defined constraints.
