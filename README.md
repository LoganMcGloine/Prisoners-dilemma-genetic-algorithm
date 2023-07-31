# Prisoners-dilemma-genetic-algorithm
This program solves the prisoners dilemma using a genetic algorithm in Java.


The prisoner's dilemma is a thought experiment used in game theory in which there are two players that each have two options
the player can confess to a crime and sell out the other or remain silent.

there 4 total outcomes of this experiment
 1) Both prisoner's A and B stay silent resulting in both parties getting 2 years in prision.
 2) one of the prisoner's A or B confessing and the other staying silent, giving the confessor 1 year and the silent party 8 years in prison.
 3) Both prisoner's confess and both get 5 years in prision.

Game theorist must try to determine how people will act here, they can either act selfishly and confess, or have act altruistically and stay silent,
  it is also important to recognize that the players must also account for what they believe the other player will do, this will likely change their decision.

This program attempts to show what decisions will likely survive the evolution process. 

This is done by using a genetic alogrithm wich simulates evolution by following these steps:
 1) Initialize a randomly generated population
 2) Calculate their fitness
 3) Select members to reproduct with those with high fitness being more likely
 4) reproduce taking attributes from both parents and having a small chance of mutation
 5) restart at 2 with new poputations for x generations 


