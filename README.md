## FullyToastedPlugin

# Collaboration Instructions
1. Set yourself up on you're favorite IDE (I'm using IntelliJ IDEA for this instance)
2. Clone the project onto your system, and add thermos-server.jar build 65 to your dependencies.
3. [IMPORTANT] Fix your 'ignore files' in order to only push source files/folders. i.e. .idea files, META-INF files.. etc.

# How to add a RankPerk
1. Update the config.yml file to reflect the correct cool down time as well as name
2. Create a new file in the Tracks/{Rank}/{RankPerk} that reflects the perk you're making.
3. Extend the RankPerk class, implment both the constructor using super() as well as the usePerk() method
4. Place your logic in the usePerk() method and that's all folks!

// For now, I've been using commands and creating instances of my {Rank}Perk and then calling the tryUsingPerk() to initiate it.
