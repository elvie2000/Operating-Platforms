package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A singleton service for the game engine
 * 
 * <p>
 * This class is implemented as a singleton. The purpose of using the
 * singleton pattern here is to ensure that only one instance of GameService
 * exists in memory at any given time. This is crucial for managing a unique,
 * shared list of games across the entire application. If multiple instances
 * were allowed, different parts of the application might interact with
 * different game lists, leading to data inconsistency.
 *
 * Characteristics of this singleton implementation:
 * 1. A private static final variable ('service') to hold the single instance.
 * 2. A private constructor ('GameService()') to prevent instantiation from
 * other classes.
 * 3. A public static method ('getInstance()') that returns the single, shared
 * instance.
 * </p>
 *
 * <p>
 * This class also uses the iterator pattern to traverse the list of games.
 * The purpose of using the iterator pattern is to provide a standard way
 * to loop through the 'games' collection without exposing its underlying
 * implementation (in this case, an ArrayList).
 *
 * Characteristics of this iterator implementation:
 * 1. We obtain an 'Iterator' object from the 'games' list.
 * 2. We use the 'hasNext()' method to check if more elements exist.
 * 3. We use the 'next()' method to retrieve the next element in the
 * iteration.
 * This is used in 'addGame' and 'getGame' to safely search for existing games.
 * </p>
 *
 * @author coce@snhu.edu
 */
public class GameService {

	/**
	 * A list of the active games
	 */
	private static List<Game> games = new ArrayList<Game>();

	/*
	 * Holds the next game identifier
	 */
	private static long nextGameId = 1;

	// FIXME: Add missing pieces to turn this class a singleton
   
   //Singleton Pattern Implementation
   
   /**
   *Private static final instance of GameService.
   *This is the single instance that will be shared across the application.
   */
   
   private static final GameService service = new GameService();
   
   /**
   *A private constructor to prevent instantiation from outside the class.
   *This enforces the singleton pattern.
   */
   
   private GameService() {
           // Private constructor to prevent direct instantiation
   }
   
   /**
   *Public static method to get the single instance of GameService.
   *
   *@return The single GameService instance.
   */
   
   public static GameService getInstance() {
           return service;
   }
   
   //Game Managemnet Methods (using Iterator Pattern)

	/**
	 * Construct a new game instance
	 * 
	 * @param name the unique name of the game
	 * @return the game instance (new or existing)
	 */
	public Game addGame(String name) {

		// a local game instance
		Game game = null;

		// FIXME: Use iterator to look for existing game with same name
      //Create an iterator to loop through the games list
      // if found, simply return the existing instance
      Iterator<Game> iterator = games.iterator();
      
      //Loop while the iterator has more games
      while (iterator.hasNext()) {
             //Get the next game from the iterator
             Game existingGame = iterator.next();
             
             //Check if the existing game's name matches the requested
             if (existingGame.getName().equals(name)) {
                     //If a match is found, set 'game' to the existing
                     game = existingGame;
                     break;
             }
      }
		
		// if not found, make a new game instance and add to list of games
		if (game == null) {
			game = new Game(nextGameId++, name);
			games.add(game);
		}

		// return the new/existing game instance to the caller
		return game;
	}

	/**
	 * Returns the game instance at the specified index.
	 * <p>
	 * Scope is package/local for testing purposes.
	 * </p>
	 * @param index index position in the list to return
	 * @return requested game instance
	 */
	Game getGame(int index) {
		return games.get(index);
	}
	
	/**
	 * Returns the game instance with the specified id.
	 * 
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	public Game getGame(long id) {

		// a local game instance
		Game game = null;

		// FIXME: Use iterator to look for existing game with same id
		// if found, simply assign that instance to the local variable
      Iterator<Game> iterator = games.iterator();
      
      //Loop while the iterator has more games
      while (iterator.hasNext()) {
            //Get the next game from the iterator
            Game existingGame = iterator.next();
            
            //Check if the existing game's ID matches the requested ID
            if (existingGame.getId() == id) {
                    //If a match is found, set 'game' to the existing game and exit loop
                    game = existingGame;
                    break;
            }
      }

		return game;
	}

	/**
	 * Returns the game instance with the specified name.
	 * 
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Game getGame(String name) {

		// a local game instance
		Game game = null;

		// FIXME: Use iterator to look for existing game with same name
		// if found, simply assign that instance to the local variable
      Iterator<Game> iterator = games.iterator();
      
      //Loop while the iterator has more games
      while (iterator.hasNext()) {
              //Get the next game from the iterator
              Game existingGame = iterator.next();
              
              //Check if the existing game's name matches the requested name
              if (existingGame.getName().equals(name)) {
                      // If a match is found, set 'game' to the existing game and exit loop
                      game = existingGame;
                      break;
              }
              
      }

		return game;
	}

	/**
	 * Returns the number of games currently active
	 * 
	 * @return the number of games currently active
	 */
	public int getGameCount() {
		return games.size();
	}
}
