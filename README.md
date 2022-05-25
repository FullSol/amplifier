# _Project 2_: Diablo III Fansite 
<hr></hr>

### Team Details
_**Team Amplifier Members**_: Calvin, Julian, Levi, Patrick, Joachim

| **Roles**: | |
| :------------ | :------:|
| Lead | Calvin |
| DevOps Engineer | Levi |
| GitFlow Master| Patrick |

<hr></hr>

## Decision: Diablo III Fansite
**Focus of fansite on based on the Diablo III theme?**
1. View rankings (You don't need to be logged in for that)
2. Add screenshots of game
3. Track user posts and comments
4. External API: (Games and Comics) [_Diablo III:_](https://develop.battle.net/documentation/guides/getting-started)
<hr></hr>

## "User" Stories (19)

**Viewers Stories** (4)
- [ ] View the rankings (Pull Ranking (from Blizzard) - our implementation of a public API)
- [ ] List (get) all image posts
- [ ] Click into a specific image post to see comments
- [ ] Viewer can Register

**User Stories:** (11)
- [ ] User can view profile - contact info, social media
- [ ] User can edit profile
- [ ] User can Login
- [ ] User can upvote
- [ ] User can downvote
- [ ] User can post screenshots
- [ ] Create a new image post
- [ ] Owning user can edit post (from specific image post)
- [ ] Owning user can delete post (from specific image post)
- [ ] User can make a comment on an image post
- [ ] Comment on posted game screenshots

**Admin Stories:** (4)
- [ ] View all users
- [ ] Activate/Deactivate accounts (users)
- [ ] Moderate user posts
- [ ] Moderate user comments


### Stretch Goals
**Moderator/Admin Story**
- [ ] For a specific user, a Moderator or an Admin has to approve their comment before it would be allowed to be seen on the website
    - This specific user has said something and been placed on “probation” and will now require a moderator (or admin) review before moving forward.
- [ ] Img Post Comment is Active/Inactive (boolean)

<hr></hr>

## Technical Requirements
- [ ] PostGreSQL for persistence
- [ ] API built with Java 8 and Spring 5
    - [ ] Java API will leverage the Spring Framework
    - [ ] Java API will use Spring Data JPA to communicate with the DB
    - [ ] Java API will be RESTful (though HttpSession will be permitted)
    - [ ] Java API will be unit tested using JUnit and Mockito, with coverage reports generated using Jacoco
- [ ] UI built with HTML, CSS, and JavaScript
- [ ] Complete CI/CD pipelines will use AWS (CodePipeline, CodeBuild, Elastic Beanstalk, and S3)

### Stretch Goals:
- [ ] Create your UI application using Angular
- [ ] Angular UI will have >= 60% test (line) coverage for all custom components (confirmed by Jasmine/Karma coverage report)
- [ ] Secure your Java API using JWTs


### Other requirements:

- [x] Application will demonstrate at least ten individual user stories
- [x] Application will leverage at least one external API
- [x] Application's own data model must be sufficiently complex (i.e. >2 tables)
- [ ] SQL DB will be deployed to the cloud
- [ ] Java API will be deployed to the cloud (AWS EC2)
- [ ] UI application will be deployed to the cloud (AWS S3)
- [ ] Java API will have >=80% test (line) coverage for service layer (confirmed by Jacoco coverage report)
- [ ] Java API will leverage Spring's MockMvc for integration/e2e tests of controller endpoints
- [x] Java API will be adequately documents (Java Docs and web endpoint documentation [Swagger/OpenAPI])
- [x] At least one external API must be leveraged


