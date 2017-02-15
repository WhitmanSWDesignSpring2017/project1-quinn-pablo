# project1-quinn-pablo
project1-quinn-pablo created by GitHub Classroom

1)	Our start method now instead of containing the logic and construction of the entire program, now really only reads in the FXML file, which it uses to build the scene then show it. There are three separate methods, one for the start button, stop button, and close button, as well as two additional helper functions to allow us to easily play the scale. We changed several functions from public to private, as their original designation was unnecessary. We also fixed the core functionality so that it actually plays a scale, rather then the simple ladder we had before.

2)	This way the entire logic and construction of the program is not contained in the ‘start’ method. It is broken into smaller bits to make the program more readable/maintainable.

3)	Speaking to a few other groups it appeared the only option was to use the dialogue window the same way we did in the first iteration of this project. This means there is still a chunk of code constructing a window in our controller (under the method for the start button being pressed). Maybe this can be done with another FXML file?

4)	We worked together on using scene builder to reconstruct the window, as well as figure out how to link the FXML file to the controller class. Quinn worked a little more on populating the ScalePlayer class’s new methods, while Pablo worked on fixing mistakes from our last project.

