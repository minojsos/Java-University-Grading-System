# Java University Grading System
<br>

<h3>Description</h3>

<hr>

<p>
    <b>The Admin Panel</b>
    <br>
    A University Grading System written in Java and uses MySQL for data storage. GUI developed using JavaFX Library.<br>
    This application allows the Administrator to login and View and Add Student Grades manually. The GPA of each student and the eligibility of the student is automatically calculated when the grades are given as the input.<br>
    The administrator is supposed to input the marks for the core modules when they are adding a new student. They may add marks for the optional modules the student has taken and this is optional. The administrator is required to
    input the Student ID (Ex: 1000, 1005), the name of the student and a password so that the student may login and view their grades and elibility. The Student's username will be the Student ID.<br>
    The Administrator is also required to add the attendance and grade point for each module the student has taken to decide whether the student has passed or failed the module. The student will be given the credits of that module if he/she has passed.
    Once an admin has completed adding marks for the Preliminary modules, they are required to continue to add the marks for Semester 1 and 2. They may not quit halfway since the data will be written to database as soon as the [Save] button is pressed in the
    preliminary marks panel. Once done adding a student, the administrator may continue adding another student by clicking on the [Next] button or click the [Finish] button to stop adding anymore students.<br>
    The Administrator may do a quick search using the search form on the right panel present in the main admin panel. An Elaborate button is present at the bottom of the search form which when clicked provides the list of modules the student has taken and
    the marks and grade that the student has earned for each module.<br>
    The Settings window allows the Administrator to change the password as well as the percentage of End of Examination and Continous Assesment marks that'll be considered when calculating the final grade.
    <br>
    <b>The Student Panel</b>
    <br>
    The Student may also login to the application to view their module results. The Username for a student is their Student ID while the password should've been assigned manually by the lecturer.
    The Student, once logged in, will be able to utilize the search form to view their results. They may not edit the Text Field to change the Search value and look for the results of other students.
    Clicking on the [Search] button will display the GPA and the Student's Eligibility. The [Elaborate] button allows the student to view a detailed list of the modules the student has taken as well as the attendance, credits, marks, grade point, grade and whether the student has passed or failed the module.
    <br>
    <i>Both the Admin and Student may logout of the Application.</i>
</p>

<br>

<h3>Features</h3>
<hr>
<ul>
    <li>Login as Admin/Student</li>
    <li>Add new Student</li>
    <li>Add Marks(End of Examination & Continous Assesments), Attendance, and Grade Point)</li>
    <li>Pick Optional modules for each student that he/she has taken and add marks, attendance and grade point for those modules too.</li>
    <li>View All Students</li>
    <li>Search a Student and view all information related to that student</li>
    <li>Change password</li>
    <li>Change End of Examination and Continous Assesment marks percentage taken into consideration when calculating the final marks for all modules</li>
    <li>Logout</li>
</ul>

<br>

<h3>Screenshots</h3>
<hr>
<br>

<img src='https://raw.githubusercontent.com/minojsos/Java-University-Grading-System/master/Screenshots/Login_Screen.png' alt='Login Screen'><br>
<img src='https://raw.githubusercontent.com/minojsos/Java-University-Grading-System/master/Screenshots/Admin_Panel.png' alt='Admin Panel'><br>
<img src='https://raw.githubusercontent.com/minojsos/Java-University-Grading-System/master/Screenshots/Search_Result_Screen.png' alt='Quick Search'><br>
<img src='https://raw.githubusercontent.com/minojsos/Java-University-Grading-System/master/Screenshots/Search_Result_Elaborate_Screen_1000.png' alt='Elaborate Search result'><br>
<img src='https://raw.githubusercontent.com/minojsos/Java-University-Grading-System/master/Screenshots/Add_Student_Screen.png' alt='Add New Student'><br>
<img src='https://raw.githubusercontent.com/minojsos/Java-University-Grading-System/master/Screenshots/Preliminary_Module_Marks.png' alt='Preliminary Module Marks insertion - New Student'><br>
<img src='https://raw.githubusercontent.com/minojsos/Java-University-Grading-System/master/Screenshots/Semester_One_Screen.png' alt='Semester I Marks insertion - New Student'><br>
<img src='https://raw.githubusercontent.com/minojsos/Java-University-Grading-System/master/Screenshots/Semester_Two_Screen.png' alt='Semester II Marks insertion - New Student'><br>
<img src='https://raw.githubusercontent.com/minojsos/Java-University-Grading-System/master/Screenshots/Settings_Screen.png' alt='Settings Screen'><br>
<img src='https://raw.githubusercontent.com/minojsos/Java-University-Grading-System/master/Screenshots/View_All_Students_Screen.png' alt='View all Students Screen'><br>
<img src='https://raw.githubusercontent.com/minojsos/Java-University-Grading-System/master/Screenshots/Student_Panel.png' alt='Student Panel'><br>
<img src='https://raw.githubusercontent.com/minojsos/Java-University-Grading-System/master/Screenshots/Student_Panel_Search_Result.png' alt='Quick Search - Students Panel'><br>

<br>

<h3>Possible Improvements</h3>
<hr>
<br>
<ul>
    <li>Student ID automatically generated</li>
    <li>Randomly generated password for students</li>
    <li>View All Modules</li>
    <li>Store all Student Marks in list until Admin confirms input. This allows the admin to cancel even after the marks has been input</li>
    <li>Password Hashing</li>
    <li>Student Panel displays all the modules elaborated directly</li>
    <li><i><b>More will be added</b></i></li>
</ul>

<br>
