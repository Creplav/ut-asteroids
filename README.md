# ut-asteroids
Asteroids for UT's Hallowengineering


#### Instuctions for installing and running the project

1. Clone the repository 
   - Create a directory where you want the project to be saved
    - Navigate into the directory with the command line using cd /path/to/directory
    - Clone the repository into the folder using: <code> git clone [link]</code> Just copy the URL of this tab without [ ]!
2. Open the project in your IDE
    <p> Using Intellij or Android studio open the project from file -> open -> project </p>
    
3. Create run configurations
   1. Click on run and find the option for "edit configurations"
    2. Click on that click on the green + in the left hand corner 
    3. Find gradle and click on it
    4. In the name type "Desktop" and in the task type <code> desktop:run </code>
    5. Click on the folder on the right side of the box that says gradle project
    6. Navigate to the desktop folder within the project and click on the build.gradle inside 
        of of the desktop folder
    7. Click apply and then ok
    8. Make sure that your desktop run configuration works by going to run -> desktop
    
4. Pull any previous changes
    1. open a terminal window inside of your project folder and type <code> git pull </code>
    
5. Make changes
6. Add changes to staging area
    1. with a terminal window open in the project folder add all of your files
    <code> git commit -A </code>
7. Commit changes
    1. Type <code> git commit -m "Message" </code> to commit your changes. 
    Please be specific with the messages. For example: "Added Something.java for use 
    in the Thing.java class file for the conversions"
    
8. Push changes
    1. Your changes cannot be accessed yet and need to be pushed to the repo
    Type <code> git push </code> to push all of your changes
    
    
