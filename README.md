# Smart Home Simulation
**Authors**: [Kakazhanova Assemgul](@Asemika), [Luzan Anna](@luzananna)
## Description
The Smart Home Simulation application is designed to virtually simulate the operations and activities within a smart home environment. It provides a platform to emulate household tasks, utilize various home devices, and analyze the usage patterns, consumption, as well as free and occupied time of individuals.


## Functional requirements
**F1** + All entities provided in the entities (devices, creatures) and home folders

**F2** + Everything is provided in the API folder

**F3** + Everything is provided in the device folder

**F4** + Everything is provided in the API folder

**F5** + Everything is provided in the creatures folder

**F6** + Events are generated in the event folder

**F7** + Events are implemented in the event folder and used for system and sensor folders

**F8** + Report generation takes place in the report folder

**F9** + Documentation is prescribed for each device


## Design patterns
### Singleton
The Configuration class applies the Singleton pattern. This pattern ensures that the class has only one instance and provides a global access point to that instance through the static `getInstance()` method. In this case, the Configuration class has a private static member `INSTANCE`, which holds the single instance of the Configuration class, and the `getInstance()` method, which returns this instance.

### Factory Method
The Configuration class has methods for creating various objects, such as `initHouse()`, `initFridge()`, `initPeople()`, `initPets()`. These methods can be considered as factory methods since they create objects of specific classes and initialize them.

### Observer
In the Configuration class, various sensors are created (e.g., `FireSensor`, `WaterLeakSensor`, `StrongWindSensor`, `PowerOutageSensor`), which are subscribers to different systems (e.g., `FireSystem`, `WaterLeakSystem`, `BackupGenerator`). This corresponds to the Observer pattern, which allows objects to subscribe and unsubscribe from changes in other objects.

### Strategy
The Strategy pattern is used in the `Oven` class. The `executeMode()` method selects a strategy according to the current oven mode and executes it. Additionally, the `addModeStrategy()` and `removeModeStrategy()` methods allow dynamically changing the oven's operation strategies.

### Composite
The `House` class uses the Composite pattern. It represents the structure of a house, consisting of floors (`Floor`) and rooms (`Room`). Floors and rooms can contain other rooms, allowing for the creation of a hierarchical structure of the house.

### Builder
Although there is no classical example of the Builder pattern in the provided code, the concept of creating a house in the `initHouse()` method of the Configuration class resembles the Builder approach. The `initHouse()` method sequentially creates floors and rooms of the house, adds windows and other devices to them, constructing the house's structure.

### Facade
The Configuration class can be seen as a facade for initializing the simulation environment. It provides a convenient interface for initializing the house, people, pets, and other environment components. All the complexity of initialization is hidden inside this class, and external components can use it to set up the simulation.
