# project1-quinn-pablo
project1-quinn-pablo created by GitHub Classroom

1) Our design creates a layout with two distinct buttons each with their own event handles. The start button shows a dialogue box that asks for an input. That input is then chopped and parsed into an integer, such that if the user entered 0-115 sets it at the starting note. Then it plays the scale. If the stop button is pressed at any time methods are called utilize built in methods to stop and clear the sequence of notes that had been created (and is currently playing). The scale is played using 2 for loops. One up, one down.


2) The dialogue box and getting the user input all happen in the method to handle when the play button is pressed, since these things will only ever occur in that scenario. We didn’t feel the need to create helper functions for these.

We did create helper functions to easily use the Midi class. These stop, clear, or play the scale. We thought especially for playing it would be more eloquent and reusable to be able to play a scale based off of just a given number, hiding the ugly for loop from the rest of the code. 


3) Hiding away the midi class interactions makes the control flow much more readable and understandable.


4) The part where we handle the dialogue box is somewhat ineloquent. Maybe it could all be contained in a function called promptForNote() or something like that, but it was a struggle even to get to this point.


5) We worked side by side. Quinn handling most of the layout and Pablo handling most of the interaction with the Midi class. It worked well since we both discussed issues we were facing with each other, so we both got to understand what the other was working on.
