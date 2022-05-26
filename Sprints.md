
# Project 2: *Team Amplifier*
<hr>

**Project Deadline:** June 3rd, 2022

_**Members**_: Calvin, Julian, Levi, Patrick, Joachim

**Roles**:
- **Lead**: Calvin
- **DevOps engineer** - Levi
- **Git Flow master** - Patrick


**Sprint Times:** Every day after lecture; Weekends TBD

<br>
<hr>

### Table of Contents
1. [Tentative Project Timeline](#tentative-project-timeline)
2. Project Details
    - [Decision: Diablo III Fansite](#diablo-iii-fansite)
    - ["User" Stories](#user-stories-19)
    - [Tables](#tables)
3. [Daily Meeting Format](#daily-meeting-format)
    - [Sprint Meeting Template (for Levi)](#for-levi-sprint-meeting-template)
4. Meeting (Stand-up) Summaries
    - [Setting things up: 5/19/22](#51922-setting-things-up)
    - [Meeting 1: 5/20/22](#sprint-1-52022)
    - [Meeting 2: 5/23/22](#sprint-2-52322)
    - [Meeting 3: 5/24/22](#sprint-3-52422)
    - [Meeting 4: 5/25/22](#meeting-4-52522)
    - [Meeting 5: 5/26/22](#meeting-5-052622)
5. [Link to Front-End Draft](https://xd.adobe.com/view/443d6501-5900-4ff2-80ec-d06c965809e9-116e/
)


<br>
<hr>

### **_Tentative_ Project Timeline:**

| Date| Schedule     |  Notes |
|--  | :---------------:     | :------------: |
| 5/18 | Sprint 0: Setting things up | |
| 5/19 | Sprint 1| |
| 5/20 | | |
| 5/21| | |
| 5/22| | |
| 5/23| Sprint 2 | TDD for Service and Controller layer |
| 5/24 |  | |
| 5/25|  | |
| 5/26| Sprint 3 | Finish backend + tests |
| 5/27| | Fix buggers; Start frontend |
| 5/28 | | |
| 5/29 | Sprint 4 | Bugs fixed |
| 5/30 |      | |
| 5/31 |  | _(**Ideally**) P2 Coding Finalized)_ |
| 6/1| Sprint 5 | Front end finished |
| 6/2| _Team Amplifier Presentation Practice_ | (_Idea: Talk about Apiary_) |
| 6/3 | _(**D-DAY**) P2 DEADLINE-Presentation Day_  |  |

[Return to: _Table of Contents_](#table-of-contents)

<br>
<hr>

### **Daily Meeting Format:**

> ##### _NOTE_: This format is adjustable. Feel free to share your suggestions so that we can make this meeting as efficient as possible!
<br>

1. **What did you do yesterday?**
    - brief rundown of what you accomplished prior to Sprint to update the team on where you are in regard to the project.
    - tasks completed will be tracked through issues and milestones (Levi)
  
2. **Did you run into any issues/problems since our last meeting?**
    - (These will typically be tackled after the meeting is over). 

3. **Agenda:**
    - important changes or suggestions that  need to be discussed as a team, etc..
    - Feel free to message into the Discord or DM Levi for anything you want to discuss for the day's Sprint OR mention it at the start of the sprint. 

4. **What do you want to accomplish by our next sprint?**
    - _*Levi will assign Issues and create milestones to each team member according to this list._
    - Milestones, individual tasks, and reminders


[Return to: _Table of Contents_](#table-of-contents)
<br>
<hr>

### (For Levi) Sprint Meeting Template

### Sprint #: XX/XX/XXXX

1. **Progress Check** 
    - Joachim: 
        - [ ]  
        - [ ]  
    - Patrick: 
        - [ ]  
        - [ ]  
    - Julian:
        - [ ]  
        - [ ]  
    - Calvin:
        - [ ]  
        - [ ]  
    - Levi:
        - [ ]  
        - [ ]  
    <br> </br>

2. **Any Issues?** 
    - [ ]  
 <br> </br>

3. **Agenda**
    - [ ]  
    - [ ]  
 <br> </br>

4. **Team Milestones/Tasks** 
- _Milestones:_
    - [ ] 
    - [ ] 
 <br> </br>
- _Issues_
    - Joachim: 
        - [ ] 
        - [ ]
    - Patrick: 
        - [ ] 
        - [ ]
    - Julian: 
        - [ ] 
        - [ ] 
    - Calvin: 
        - [ ] 
        - [ ] 
    - Levi: 
        - [ ] 
        - [ ] 
- _Reminders: Topics to understand and implement:_
    - [ ] 
    - [ ] 
    - [ ] 
 <br> </br>


[Return to: _Table of Contents_](#table-of-contents)

<br>
<hr>

### Decision: Diablo III Fansite
**What do we want to focus our fansite on based on the Diablo III theme?**
1. View rankings (You don't need to be logged in for that)
2. adding screen shots (allowing posting, 1 layer comments)
    - don't want to track comments on top of comments on top of replies, etc
    - this will force us to use a blob, bytea
3. External API: (Games and Comics) [_Diablo III_](https://develop.battle.net/documentation/guides/getting-started)

AVOID:
- User board
    - complicated -> need to have a comment system, users linking into that, replies to people, doPost, etc.

_Resources_
- [Raider](https://raider.io)
- [Diablo](https://maxroll.gg/)
- [_Diablo III_ API](https://develop.battle.net/documentation/guides/getting-started)

[Return to: _Table of Contents_](#table-of-contents)
<br>
<hr>

### "User" Stories (19)

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


[Return to: _Table of Contents_](#table-of-contents)
<br>
<hr>

### Tables

##### *(as reflected in ER Diagram)*

To view ER Diagram, click [here](https://github.com/FullSol/amplifier/blob/dev/ER%20Diagram.png).

**users**
1. id
2. username
3. email
4. password
5. first_name
6. last_name
7. character_id
8. social_media_id
9. join_date
10. role_id
11. active

**user_character**
1. id
2. character_realm
3. character_name

**user_roles**
1. id
2. role (Viewer/User/Admin)

**user_social_media**
1. id
2. twitter_handle
3. facebook_link
4. instagram_handle

**img_posts**
1. id
2. img_location
3. author_id 

**img_post_comments**
1. id
2. comment_text
3. img_post_id
4. author_id
5. comment_date



[Return to: _Table of Contents_](#table-of-contents)
<br>
<hr>


### 5/19/22: Setting things up

- [x] Decided team member roles
- [x] Decided project goal: Diablos III Fansite
    - Diablos III external API
    - Fan site functions. Reference [Project Details](#diablo-iii-fansite)
- [x] Briefly go over GitHub PM, Git branching. Established communication on Discord and discuss sprint format.
- [x] Create Github repository

_Issues_
- Calvin:
    - [ ] Apiary documentation
    - [ ] Set up Postman workspace
- Levi
    - [ ] Update/set up Sprints document
    - [ ] Create Git branching guidelines document

[Return to: _Table of Contents_](#table-of-contents)
<br>
<hr>

### Sprint 1: 5/20/22
1. **Progress Check** 
    - Calvin:
        - [x] Apiary documentation
        - [x] Set up Postman workspace - (will probs not be using it bc only 3-4 ppl can be added for free in a workspace) -> Julian and Patrick can potentially set up a new one, invite Calvin so he can duplicate it
        - [x] Project has been initialized
        - [x] Sent project proposal to Azhya
    - Levi:
        - [x] Update/set up Sprints document
        - [x] Create Git branching guidelines document
    <br> </br>

2. **Any Issues?** 
    - [x] Make sure everyone is receiving GitHub notifications (keep Repo on "WATCH").
    - [x] Go over Reviewing pull requests.
 <br> </br>

3. **Agenda**
    - [ ] Sprints.md & Git Branching Guidelines -Levi
    - [ ] Review User Stories (19)
    - [ ] Review Project Tables
    - [ ] Go over Apirary documentation (work in progress) - Calvin
    - [ ] Go over project initialization - Calvin
    - [ ] Set expectations for getting work completed & communication (open conversation, holding each other accountable)
        - Issues will be posted for the weekend. If you need help/get stuck/fall behind.... COMMUNICATE(**DISCORD**) :)
        - Calvin - Group project: Relying on each other and each other's work to move forward in the project. Don't let any issue you have just sit. Reach out via Discord, DM.
            - Complete tasks
            - Respect one another
        - Julian is very excited, is very optimistic, wants to see the project already running
        - Joachim: "Knowing what exactly is being asked of me."
        - Levi: Organization
        - Patrick: Communication, commmunication, communication! 
    - [ ] Patrick, Calvin, Levi -> meeting for Git branching
        - Feel free to join!
 <br> </br>

4. **Team Milestones/Tasks**
- _Milestones:_
    - [ ] [Review API Documentation](https://p2amplifier.docs.apiary.io/#)
    - [ ] Git branching guidelines
    - [ ] Complete issues by our next sprint
    - [ ] Read/Practice examples of String Boot, Restful API, Sprint testing
    - [ ] Familarize yourself with "user" stories & tables
 <br> </br>
- _Issues_
    - Joachim:
        - [ ] Pull your dev branch; Review the Branching doc
        - [ ]
    - Patrick:
        - [ ] Pull your dev branch; Review the Branching doc
        - [ ]
    - Julian:
        - [ ] Pull your dev branch; Review the Branching doc
        - [ ]
    - Calvin:
        - [ ] Merge into the dev branch - Project initialization
        - [ ] CI/CD pipelines will use AWS (CodePipeline, CodeBuild, Elastic Beanstalk, and S3)
        - [ ]
    - Levi:
        - [ ] How to review pull requests (add to branching guidelines)
        - [ ] CI/CD pipelines will use AWS (CodePipeline, CodeBuild, Elastic Beanstalk, and S3)
        - [ ] Issues & Milestones
        - [ ] Pull your dev branch
- _Reminders: Topics to understand and implement:_
    - [ ] Study for your quiz!
    - [ ] No QC next week!
    - [ ]
 <br> </br>


[Return to: _Table of Contents_](#table-of-contents)

<br>
<hr>

### Sprint 2: 5/23/22

1. **Progress Check**

- _Spring 1 Milestones:_ How do we feel about them? Did the check marks on the issues help?
    - [ ] [Review API Documentation](https://p2amplifier.docs.apiary.io/#)
    - [ ] Git branching guidelines
    - [ ] Complete issues by our next sprint
    - [ ] Read/Practice examples of String Boot, Restful API, Sprint testing
    - [ ] Familarize yourself with "user" stories & tables
    - Joachim:
        - [x] Feels good!
        - [ ] branching
    - Patrick:
        - [x] ImgPost test - 70% -issue with build
        - [x] Good and bad~
    - Julian:
        - [x] Reviewed everything; watched vids on Utube for integrating Angular framework
        - [x] started testing
    - Calvin:
        - [ ] Updated Postman/OpenAPI documentation
        - [ ] User Controller -> created examples
        - [ ] User Controller Test -> created examples 
            - did lots of research on Integration test; added a video as a resource (and it is included in the issue)
        - [ ] Reviewed CI/CD pipelines
        - [ ] Comments Model
        - [ ] Service, but not pushed until
        - [ ] ER Diagram
    - Levi:
        - [ ] Updated branching guidelines
        - [ ] Updated Sprints.md
        - [ ] Postman/OpenAPI documentation
        - [ ] CI/CD pipelines
        - [ ] Updated issues
    <br> </br>

2. **Issues/Team Discussions**
    - [ ] Patrick and Julian - create postman to copy over openAPI
    - [ ] Feedback on how issues are being assigned, etc. for Levi. Anything to improve on?
 <br> </br>

3. **Agenda**
    - [ ] Discuss Sprint 2 - TDD
        - we test, without writing what we're testing for (TDD) to make sure we're all getting experience in each of the layers
    - [ ] Discuss Sprint 3 - Finish all backend + assignments were randomly made to ensure everyone has experience with every layer.
        -  Pleaes let Levi know if there are any issues.
 <br> </br>

4. **Team Milestones/Tasks**
- _Milestones:_ 3
 <br> </br>
- _Issues_
    - already assigned
    - Levi:
        - [ ] Update README.md

 <br> </br>


[Return to: _Table of Contents_](#table-of-contents)

<br>
<hr>

### Sprint 3: 5/24/22

**Summary for Calvin:**
- Levi updated README.md. ; Our milestone for our most recent spring was TDD, and we divided up tests in our team to write integration tests for the service and controller layers of each of our tables. This is still in progress. We had some confusion involving writing the bare minimum of code needed (skeleton) for our tests but also not stepping on any other assigned tasks (for the backend). This was clarified in today's stand up meeting.
- Our next milestone is to complete our backend (functionality). Issues to split up tasks have already been created and several members have alrady jumped the gun and finished their issues. Now that that we clarified any confusion, we will continue to do more more testing so we can achieve the goal of 80% coverage. We suspect that merging all of our branches together may lead to some conflict, but we will resolve those together as a team. 
- Issue to bring up to Azhya: 
    - [Issues being used for tracking current work](https://github.com/FullSol/amplifier/pull/78)
    - Service testing with annotations

1. **Progress Check** 
    - Joachim: 
        - [x] Social Media Controller Test
        - [ ] User Service Test - in progress
        - [ ] Character Service Test
        - [x] Character controller
        - [x] ImgPost Service + Impl
        - [x] Comments Repo + impl
    - Patrick: 
        - [x] ImgPost Controller Test - in progress
        - [ ] UserRole Service Test - in progress
            - created draft pull request
    - Julian:
        - [ ] Character Controller Test - in progress
        - [ ] Social Media Service Test - in progress
    - Calvin:
        - [ ] ImgPost Service Test - in progress
        - [x] UserController Test
        - [ ] Reviewing code
        - [x] ImgPost Model
        - [x] User Model
    - Levi:
        - [x] Comment Controller Test - in progress
        - [x] UserRole Controller Test - in progress
        - [ ] Comment Service Test - in progress
        - [x] Updated README.md
        - [x] Updated Calvin's pull request info in Branching doc.
        - [x] Character repo

    <br> </br>

2. **Any Issues?**
    - [ ] Patrick/Julian - Postman setup?
        - create it, add Calvin, and Calvin will copy shtuffffff
 <br> </br>

3. **Agenda**
    - [ ] Pull requests to show progress
    - [ ]
 <br> </br>

4. **Team Milestones/Tasks**
- _Milestones:_
    - [ ] Functionality first, testing after.
    - [ ]
 <br> </br>
- _Issues_
    - Calvin:
        - [ ] URI Changes
        - [ ] UserController LocalDate & JSON 
    - Levi:
        - [ ] implementing CI/CD pipeline

- _Reminders: Topics to understand and implement:_
    - [ ] Hackerrank Greedy Florist

 <br> </br>


[Return to: _Table of Contents_](#table-of-contents)

<br>
<hr>

### Meeting #4: 5/25/22
**Calvin's Summary**
- The goals of our current sprint is to finish our backend and testing by tomorrow. Our meeting's focus was checking in with the team to gauge where each of us were in terms of progress, and clarifying project naming conventions as well as any other misunderstandings or confusion (Ex: Service layer = Service + ServiceImpl; @Repostory annotaton takes care of RepoImpl for us)
- As a team yesterday, we set and agreed on a basic project timeline. Again, we want to have backend and testing finished by tomorrow, and we want to fix any backend merging conflicts or bugs by (ideally) the end of this week
- We also discussed the reqs for our front end... We will be collaborating on what we want it to look like tomorrow...

1. **Progress Check**: Where are we in regards to completing our Milestone for tomorrow by tomorrow?
    - Joachim: "real good"
        - [ ] pushed up CharacterServiceTest
    - Patrick:
        - [ ] Comment Controller
        - [ ] UserRoleService
        - [ ] UserCharacter model - add flesh and bones to skeleton
        - [ ] UserService - add business logic
    - Julian:
        - [ ] UserCharacterTesting
        - [ ] SocialMedia
    - Calvin:
        - [ ] Confident
    - Levi:
        - [ ] good~~
    <br> </br>

2. **Any Issues?** 
    - [ ] Issue Service = Service && ServiceImpl (Levi will update issues so there is not misunderstanding)
    - [ ] UserSocialMedia
        - paths:
            - socialmedia.facebook.
            - socialmedia.instagram.handle
        - CREATE = Adding their social media information (add link)
        - UPDATE = Editing a user's social media info
        - we ourselves may not use all of the CRUD operations for the webiste, but others who use our API might! More will come in the future

 <br> </br>

3. **Agenda**
    - [x] Bug - Repo:Service
    - [x] Bug - Only need Repo layer (not Repo AND RepoImpl). Your Repo = RepoImpl
        - the annotation takes care of the implementation for you, so you don't need to create the implementation yourself
    - [ ] Front-end Design discussion (ex: Reddit design?) >stick to
        - connecting Blizzard rankings
        - what pages?
            - login page
                - login form
            - logout page
            - rankings page
            - user profile
            - registration page
                - registration form
            - image posts page
            - add comments form
            - form to add character info

 <br> </br>

4. **Team Milestones/Tasks**
- _Milestones:_
    - [ ] Consider Front-End Design to have a discussion by next meeting
    - [ ] Milestone 3
 <br> </br>
- _Issues_: already assigned
    - Levi:
        - [ ] Compile all updates into one section for easy reference

 <br> </br>


[Return to: _Table of Contents_](#table-of-contents)

<br>
<hr>

### Meeting 5: 05/26/22
Summary:
Project milestone for finishing tests and backend roughly met. Patrick, Calvin and Levi are reviewing all pending pull requests and requesting changes as needed. Our gaol is to finish those changes by tomorrow. Calvin has started a rough design for front end. Starting from today, debugging the backend will start with Calvin and Levi. Julian will lead the front-end team and begin working with Patrick and Joachim to start the front-end process. Once Calvin and Levi are done debugging, they will start catching up to front-end. Tasks to divide up front-end will be assigned by tomorrow.


1. **Progress Check**: What did we get done? What is still pending? (If some items are still pending) When do you think you can get it done?
    - Joachim:
        - [ ] All good to go
    - Patrick:
        - [ ] UserCharacterModel - will return to it!
            - Julian may have created it and the branches may have been merged
        - [ ] Items in the middle of review
    - Julian:
        - [ ] Worked on all tickets
        - [ ] Still working on the ticket that was sent back
    - Calvin:
        - [ ] started some front end design
        - [ ] bug fixes  + reviewing
    - Levi:
        - [ ] finished my tickets
    <br> </br>

2. **Any Issues?**
    - [ ] ClassPath changes? - This is the difference between Mac and Windows users OR you have done something that required yoru class path to change. Pleae just ignore it and add it with the rest of your work when you commit.
        - wouldn't the changes that you bring into dev automatically change the class path for other people on our end? Because the class path is changed by your IDE, whatever changes that occur in class path need to be pushed into dev.
        - solution: `git add .`
 <br> </br>

3. **Agenda**
    - [ ] on to debugging and front end...
    - [ ] While reviewing, whomever is reviewing will make comments on your code and will either approve your code or request changes. You will receive an email if changes are requested.
    - [ ] Website design
        - Home page: list of all image posts 
            - title field 
            - count of the comments
            - expanding the posts and comments via bootstrap and writing animation with css
        - Forms: login form, registration form, profile form, social media form, character form
        - Ranking page (Blizzard API)
 <br> </br>

4. **Team Milestones/Tasks**
- _Milestones:_
    - [ ] Make any requested changes from pull requests by tomorrow! 
 <br> </br>
- _Issues_
    - Levi: 
        - [ ] CI/CD implementation
        - [ ] Google fonts for front-end development
- _Reminders: Topics to understand and implement:_
    - [ ] Portfolio due by tomorrow
    - [ ] HackerRank Sorting
 <br> </br>


[Return to: _Table of Contents_](#table-of-contents)

<br>
<hr>

### Rules and Updates
1. 