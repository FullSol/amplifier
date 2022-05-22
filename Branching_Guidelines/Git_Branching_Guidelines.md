# Team Branching Guidelines <hr>

### Navigation:
1. Important reminders:
    - [Clone Amplifier into your computer.](#remember-to-clone-our-github-repo-is-cloned-into-your-computer) 
    - [Before starting anything, make sure your dev branch is up to date...pull!](#before-starting-anything-make-sure-your-dev-branch-is-up-to-date)
    - [If you created a branch, and updates were made in dev... merge.](#if-you-created-a-branch-and-updates-in-dev-were-made-merge)
    - [Only make changes in your own branch. Switch! Don't make changes to dev!](#always-remember-to-switch-to-your-respective-branch-to-make-changes-please-do-not-make-changes-to-dev)
    - Always request reviews from Patrick. Patrick will in turn request reviews from Calvin. Calvin will request reviews from Patrick or Levi. 
2. [How to create a branch from your assigned issue](#creating-your-branch-from-your-assigned-issue)
3. [How to create Pull Requests](#creating-a-pull-request)
4. [Reviewing Pull Requests](#reviewing-pull-requests)
5. [Merging into dev (for Gitflow master Patrick)](#merging-into-the-dev-branch)


<br>
<hr>

### Remember to clone our GitHub Repo is cloned into your computer! 
`git clone (remote_repo_link)` 
- [Team Amplifier Project 2 Repo](https://github.com/FullSol/amplifire)
<br>
<hr>

### Before starting anything, make sure your dev branch is up to date. 
1. `cd amplifire`
2. Confirm you're in the _dev_ branch. If not, commit or stash your changes in the branch you're in, and `git switch dev` (switch your branch to dev).
3. `git pull`.
    - This will fetch and download content from a remote repository and immediately update the local repository to match that content.
<br>
<hr>

### If you created a branch, and updates in dev were made... merge. 
1. Save and `git commit` or `git stash` your work on the branch you're working on.
2. `git switch dev`
3. `git pull`.
4. `git switch (branch you want to keep working on)` : Return to the branch you're working on. 
5. `git merge` -> (if needed) `:wq`
    - This will merge the updates from the dev branch to the branch that you're currently in so that you can work with the most recent changes. 
<br>
<hr>

### ALWAYS REMEMBER TO SWITCH TO YOUR RESPECTIVE BRANCH TO MAKE CHANGES. PLEASE DO NOT MAKE CHANGES TO DEV. 
1. `git switch (your branch based on the issue you're working on)`

>Our Gitflow master, Patrick (and others), will be the only one who can merge any changes you made in your branch to dev after reviewing. That said, remember to always add Patrick and Calvin in your pull requests. 
<br>
<hr>


### Creating your branch from your assigned issue:
1. Navigate to the Issues tab.
![Issues](./images/Issues.png)

2. Select the Issue that you've been assigned to and want to work on.

3. Go to Development. Click on "Create a branch".
![2+3](./images/Go%20to%20Development.png)

4.
![4](./images/Create_branch_for_issue.png)  
- Select **"Create branch."**  
- Our branch source will always be "dev". Calvin has already set it as our default, so we don't need to worry about it. 

5. Copy and paste the following code into your terminal. (Make you have `git pull` in our dev branch so you're up to date first!) 
![Copy and paste](./images/Screen%20Shot%202022-05-20%20at%2006.32.55.png)

6. When you created your branch, your issue should look sometthing like this: 
![finished](./images/Finished%20creating%20branch.png)
- Your branch should be under Development.
<br>
<hr>


### Creating a pull request: 
1. _Once you have finished your work issue or are ready to commit to ask others to review your work, remember to save your changes, commit them, and push them. This will be from the branch that you're in._
    1. `git add (file name)` or `git add .` (if you're ready to commit everything)
    2. `git commit -m "(your_message)"
    3. `git push`
2. Awesome work! Now... navigate to our GitHub remote repository. For quick access, here is the [link](https://github.com/FullSol/amplifire).
3. You should see the following:
![PullReq1](./images/PullRequest_1.png)
4. Click on **Compare & Pull Request**
5. You should see the following:
![PullRequest2](./images/PullRequest_2.png)
    - *Reviewers*: No matter what, **please request reviews from Patrick.**.
    - *Assignee*:  Yourself
    - *Labels*: This will match your issue label.
    - *Projects*: Team Amplifier (seting this will update our project board)
    - *Milestones*: Will match your issue
6. Add any comments you want to make.
7. Click **Create pull request**
8. When this has been reviewed and approved, Patrick will go ahead and merge this into the dev branch. Merging into the dev is most likely going to happen every day, if not several times a day as we get closer to the deadline, so no matter what, remember: `git pull` in your dev branch!

### Reviewing Pull Requests



### Merging into the dev branch
