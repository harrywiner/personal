title: Frogger readme.txt
copyright: (c) 2009-2014 @whaleygeek
start-date: 21 May 2009
author: David Whale
warranty: None
licence:
  Please use this code as an example in teaching courses, or as the basis
  for other applications. There are no restrictions to it's use, providing
  that you do not restrict my rights in any way.

Frogger is a classic game from the 1980's.

You have multiple layers of obstacles, all moving in different directions
and at different rates, and you have to get the frog from the start position
over to the house.

The four key elements of a good design are:
  ABSTRACTION   - separating the "what" from the "how"
    (you should use object in the "what" domain)

  ENCAPSULATION - hiding the "how" inside objects
    (you should define behaviour in the "how" inside objects
    
  COUPLING       - low coupling between objects is good
    (you should reduce tight dependencies between objects so that they
    can be reused in other programs easily)
    
  COHESION      - tight cohesion within an object is good
    (code should be written as close to where it naturally belongs as possible,
    so that behaviour and the state associated with that behaviour are
    very close togther in the code)

This example shows extensive use of inheritence, which can be seen in the
object tree on the right in Greenfoot. The main benefit of inheritence is that
code can easily be reused by putting it in one place. 

Obstacle is all about bumping into things that will kill you
Mover is all the behaviour associated with moving an object.
AutoMover is the added behaviour associated with objects that move themselves.

Thus, you can see that the Frog is a Mover because it moves, but a Spider
is an AutoMover because it moves on it's own.

It is very easy to add new obstacles and auto moving objects on the screen
just by inheriting from the appropriate parent class to get the behaviour
you need.

Note also it helps to explain encapsulation and coupling a bit.

The River and the Road have the createImage inside them, and this completely 
defines their behaviour and visual apperance. 

The FroggerWorld has all the operations like gameOver()
that are associated with the world, inside the world, rather than being
peppered all over the other objects.

END.
