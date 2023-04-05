#Problem summary: To make air_conditioner_remote_controller 
#with power(on/off), showing power status, showing product info.,temperature(up/down) etc..
class RemoteController:
    def __init__(self, manufacturer, date):
        self.manufacturer = manufacturer
        self.date = date
        self.power = 'off'
        
    def powerupdate(self):
        if self.power == 'off':
            self.power = 'on'
        else:
            self.power = 'off'
        
    def print_current_status(self):
        print("Power is " + self.power)
        
    def print_product_information(self):
        print("Made by " + self.manufacturer + ", in " + self.date)
        
        
class AirConditionerRemoteController(RemoteController):
    def __init__(self, manufacturer, date):
        super().__init__(manufacturer, date)
        self.temperature = 25
        
    def temperature_up(self):
        if self.power == 'off':
            print("Please turn on the power.")
        elif self.temperature < 30:
            self.temperature += 1
            print("Temperature is " + str(self.temperature))
        else:
            print("temperature is already maximum")
            
    def temperature_down(self):
        if self.power == 'off':
            print("Please turn on the power.")
        elif self.temperature > 16:
            self.temperature -= 1
            print("Temperature is " + str(self.temperature))
        else:
            print("temperature is already minimum")
