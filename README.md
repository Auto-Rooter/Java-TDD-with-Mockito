## Types of mock:
- __Stub__: return unimportant values (Null, Zero, False), but we can see how it work (How it called, how it was used).
- __Mock__ : Can be a convincing imitation of the real service , it can be configured to interact with your code (More complex implementation = More Troubles).
- __Fake__ : *Not Real* implementation of something like Faking the Memory Database.
- __Spy__ : Here it a Little bit different , You take a __Real__ object that does it`s job perfectly fine but wrap it with fake behavior (half way between the Mock and Real Object).


## Mock is Fast and Portable:
- The point of having Mock is to make tests fast and portable ,Ex:
    >Setting up a database connection for your test cases
- Unit tests should run in milliseconds .
- Unit tests should run anywhere (Portable) Ex: maybe it will run in CI Server, your team laptops , etc...
- Once you step outside the JVM is a unit test really a unit test? 🤔                                                      

## Mock is Flexible:
- A mock can be easily rigged to do anything.
- Some test scenarios can never happen.
- Some test scenarios would be very hard to cover.
- Some test scenarios are outside of your control, Ex: 3rd party Services.

## Design advantages of using Mock:
- Mock encourage you to Splice Services off the core of your code and that is avery useful.
- Mock encourage you to do a Dependency Injection which prevent tight coupling in your code.
- Easy use of mocks drives separation of concerns into the code.
- You could mock static methods, but why would you? Java giving us interfaces and containers for dependency injection.

## Use Mock wisely:
- you can mock a POJO , But do you need to? *Isn`t simpler to just create POJO that contains the values that it need to create a mock (Unless its out of your control like 3rd party API)* -__BUT REALLY DONT DO THAT BY DEFAULT__ -.
- If you Over Mocking your code then you will end up in a situation like Looking in a mirror.
- If things are tested in Blocks, it can be hard to move code around and the test can be slow.
- Find the balance between Mocking everything out and bringing sensible things together in order to make our test like in real world.
