GRADE: 32/32
------------

Functional requirements - 10 points
===================================
* 1/1 The window should have a Play Scale and a Stop Playing button.
* 1/1 When the user clicks the Play scale button, a dialog appears asking the user for a note number in the range 0 to 115.
* 1/1 Then an 8-note scale is played starting at the given note.  The scale should be the usual Do Re Mi Fa Sol La Ti Do notes going up in pitch.  After playing the scale going up, it should then play the same scale again but going down from the highest note. 
* 0/0 The user might click the Play scale button when a scale is already being played. If the user clicks OK, then the scale being played should immediately stop and the new scale should be played instead. If the user clicks Cancel, then the scale currently playing should continue playing.
* 1/1 When the user clicks the Stop playing button, the scale should stop playing immediately. 
* 1/1 The Play button and the Stop button should be visually distinct. 
* 1/1 The two buttons should be centered in the window next to each other but not touching each other.
* 1/1 If the user shrinks or expands the window (for example, by dragging an edge or corner), the two buttons should remain centered in the window.
* 1/1 The window should have a File menu with one menu item Exit. 
* 1/1 If the user selects this menu item, then the window disappears and the application quits.
* 1/1 When the user clicks the close box (in the upper right or left corner of the window), the application quits just like when the user chooses the Exit menu item.

Implementation requirement - 8 points
======================================
* 8/8 The ScalePlayer class should no longer contain any code to create, lay out, or style GUI elements.  This should all be handled through FXML and CSS.

Style - 10 points
================
* 4/4 Self-explanatory code: names, javadoc, inline comments.
* 2/2 Appropriate use of basic Java language constructs; reasonably concise code.
* 2/2 Reasonable choices of type modifiers in Java code. 
* 2/2 Minimal, well-formatted FXML and CSS code.

Stretch goal - Extra Credit
===========================
* 0/0 

Reflection - 4 points
=====================
* 1/1 Design overview
* 2/2 What's elegant or not?
* 1/1 How did your team collaborate?
