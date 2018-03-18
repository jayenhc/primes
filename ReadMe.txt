Write a RESTful service that calculates and returns all the prime numbers up to an including a number provided.

Example
The REST call should look like  http://your.host.com/primes/10  and should return JSON content:

{
  “Initial”:  “10
  “Priimes”: [2,3,5,7]
}

Requirements
The project must be written in Java 8.
> done
The project must use Maven OR Gradle to build, test and run.
> done
The project must have unit and integration tests.
> done
The project must run, in that the service should be hosted in a container e.g. Tomcat, Jetty, Spring Boot etc.
> done
You may use any frameworks or libraries for support e.g. Spring MVC, Apache CXF, Jackson etc.
> done
The project must be accessible from Github.
> done

Optional Extensions
Consider supporting varying return content type such as XML based on requested media type.
> done
Consider ways to improve performance e.g. caching, threading
> done
Consider supporting multiple algorithms based on optional parameters
> done
Consider adding API documentation
> todo