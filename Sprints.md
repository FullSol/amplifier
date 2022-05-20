
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
4. Meeting Summaries
    - [Setting things up: 5/19/22](#51922-setting-things-up)
    - [Scrum 1: 5/20/22](#spring-1-52022)


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
| 5/23| Sprint 2 | |
| 5/24 | Sprint 3 | |
| 5/25| Sprint 4 | |
| 5/26| Sprint 5| |
| 5/27| Sprint 6 | |
| 5/28 | | |
| 5/29 | | |
| 5/30 | Sprint 7      | |
| 5/31 | Sprint 8 | _(**Ideally**) P2 Coding Finalized)_ |
| 6/1| Sprint 9 |  |
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

**User Roles:**
- [ ] Viewers (can ony view; unregistered)
- [ ] Users (special access - do stuff)
- [ ] Admin

**User**
- [ ] Id
- [ ] Username
- [ ] First name
- [ ] Last Name
- [ ] Email
- [ ] RoleId
- [ ] Social Media
- [ ] Status: (account is Active/Inactive = True/False = boolean)
- [ ] Join Date
- [ ] Character realm
- [ ] Character name

**Img-Posts**
- [ ] Id
- [ ] Image location
- [ ] Author

**Comments**
- [ ] Id
- [ ] Text
- [ ] Author
- [ ] Date


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
        - [x] Set up Postman workspace
        - [x] Project has been initialized
        - [x] Postman has also been setup (will probs not be using it bc only 3-4 ppl can be added for free in a workspace) -> Julian and Patrick can potentially set up a new one, invite Calvin so he can duplicate it
        -[x] Sent project proposal to Azhya
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
        - Group project: Relying on each other and each other's work to move forward in the project. Don't let any issue you have just sit. Reach out. 
        - Complete tasks
        - Respect one another
        - Julian is very excited, is very optimistic, wants to see the project already running
        - Joachim: Knowing what exactly is being asked of me.
        - Levi: Get your $tuff organized af
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





