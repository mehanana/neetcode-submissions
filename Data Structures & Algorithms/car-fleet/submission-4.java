class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        /*
        destination = target miles away
        car can't pass a car ahead of it
        car can catch up to a car and then drive at the same speed as the car ahead of it
        car fleet = non empty set of cars driving at the same pos and same speed (single car is also a fleet)
        if a car catches up to a car fleet the moment it arrives at the destination, the car is considered part of that fleet
        return number of different car fleets

        target = 10, position = [1, 4], speed = [3, 2]
        1st car = 3 mph @ 1 mile, 2nd car is 2 mph @ 2 miles
        - 1 hr --> 4, 6
        - 2 hr --> 7, 8
        - 3 hr --> car 1 catches up and will go at 2 mph for the rest of the trip


        target = 10, position = [4, 1, 0, 7], speed = [2, 2, 1, 1]
        - 1st car = 2mph @ 4 miles, 2nd car = 2mph @ 1 mile, 3rd car = 1mph @ 0 mile, 4th car = 1 mph @ 7 miles
        - 1 hr --> car1 = 6, car2 = 3, car3 = 1, car4 = 8
        - 2 hr --> car1 = 8, car2 = 5, car3 = 2, car4 = 9
        - 3 hr --> car1 = 10, car2 = 6, car3 = 3, car4 = 10

        - cars become 1 fleet when they reach another car or reach the finish line at the same time
        - start off with number of fleets = length of position
        - while all cars not at finish line
            - add the speed to current position
            - if a car reaches another car, replace the speed of it with that car's speed and subtract 1 from fleets
            - if a car reaches the finish line, add 1 to the number of fcars at the finish line in that iteration of the loop and then subtract (numCars + 1) from the number of fleets
        
        - return number of fleets



        - sort cars by position descending
        - for each car, compute time = (target - position) / speed
        - if time > stack top → new fleet, push time
        - if time ≤ stack top → absorbed, skip
        - return stack.size()
        */

        int[][] cars = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a, b) -> b[0] - a[0]);

        /*
        Stack<Double> times = new Stack<>();
        for (int i = 0; i < cars.length; i++) {
            double curTime = (double)(target - cars[i][0]) / cars[i][1];
            if (!times.isEmpty()) {
                if (curTime > times.peek()) {
                    times.push(curTime);
                }
            } else {
                times.push(curTime);
            }
        }

        return times.size();
        */

        int fleets = 1;
        double prevTime = (double)(target - cars[0][0]) / cars[0][1];
        for (int i = 1; i < cars.length; i++) {
            double curTime = (double)(target - cars[i][0]) / cars[i][1];
            if (curTime > prevTime) {
                fleets++;
                prevTime = curTime;
            }
        }
        return fleets;
    }
}
