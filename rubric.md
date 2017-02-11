GRADE: 32/32
------------

Functional requirements - 16 points
===================================
* 1/1 The window should have a Play Scale button.
* 1/1 The window should have a Stop Playing button.
* 3/3 When the user clicks the Play scale button, a dialog appears asking the user for a note number in the range 0 to 115 (see the window on the right above). 
* 1/1 Then an 8-note scale is played starting at the given note.
* 1/1 The scale should be the usual Do Re Mi Fa Sol La Ti Do notes going up in pitch. 
* 1/1 After playing the scale going up, it should then play the same scale again but going down from the highest note. 
* 1/1 The user might click the Play scale button when a scale is already being played. If the user clicks OK, then the scale being played should immediately stop and the new scale should be played instead. If the user clicks Cancel, then the scale currently playing should continue playing.
* 1/1 When the user clicks the Stop playing button, the scale should stop playing immediately. 
* 1/1 The Play button and the Stop button should be visually distinct. 
* 1/1 The two buttons should be centered in the window next to each other but not touching each other.
* 1/1 If the user shrinks or expands the window (for example, by dragging an edge or corner), the two buttons should remain centered in the window.
* 1/1 The window should have a File menu with one menu item Exit. 
* 1/1 If the user selects this menu item, then the window disappears and the application quits.
* 1/1 When the user clicks the close box (in the upper right or left corner of the window), the application quits just like when the user chooses the Exit menu item.

Implementation requirements - 8 points
======================================
* 2/2 Clone the given GitHub repository and push your code to it.
* 2/2 Use JavaFX.
* 1/1 Use the given MidiPlayer class.
* 1/1 Put all your code in the provided ScalePlayer class.
* 2/2 Document all methods using JavaDoc.

Elementary style - 4 points
==========================
* 1/1 Some attempt at descriptive method, parameter, and variable names.
* 1/1 Consistent indentation.
* 2/2 Appropriate use of basic language constructs; reasonably concise code.

Next time I will look for "self-explanatory code" and appropriate use of 
access modifiers.

Stretch goal - Extra Credit
===========================
* 0/0 

Reflection - 4 points
=====================
* 1/1 Design overview
* 2/2 What's elegant or not?
* 1/1 How did your team collaborate?
