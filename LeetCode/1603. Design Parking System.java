class ParkingSystem {
    int[] parkinglot = new int[3];
    public ParkingSystem(int big, int medium, int small) {
        parkinglot[0] = big;
        parkinglot[1] = medium;
        parkinglot[2] = small;
    }
    
    public boolean addCar(int carType) {
        if(carType == 1){
            if(parkinglot[0]> 0){
                parkinglot[0]--;
                return true;
            }
            else return false;
        }
        if(carType == 2){
            if(parkinglot[1] > 0){
                parkinglot[1]--;
                return true;
            }
            else return false;
        }
        if(carType == 3){
            if(parkinglot[2] > 0){
                parkinglot[2]--;
                return true;
            }
            else return false;
        }
        return true;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
