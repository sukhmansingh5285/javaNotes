// this code is not for run

// 1. Standard For Loop (before)
for (DataType item : collectionOrArray) {
    // Code to execute for each item
}


//1. Arrays
    int[] numbers = {10, 20, 30};
    for(int num: numbers)
    {
      println(num);
    }

//2. Collections
  List<String> names = List.of("Alice", "Bob", "Charlie");
  for(String name: names)
  {
    System.out.println("Hello, "+name);
  }

// new forEach method

//1. Lambda Expression (it helps to perform actions in a single line)
List<String> fruits = Arrays.asList("Apple", "Banana", "Cherry");
fruits.forEach(fruit -> System.out.println(fruit));

//2. Strings   (to access the char in String, first you have to convert it into the character Array)
String text = "JAVA";
for(char c: text.toCharArray())
{
  System.out.println(c);
}

//3. Map
Map<Integer, String> map = Map.of(1, "One", 2, "Two");
map.forEach((key, value)->{
  System.out.println("ID: "+key+"Name: "+value);
})