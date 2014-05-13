/**
 * @author Stephan Kretschmann, Gernot Miehlke, Alexander Radom
 * @version 2009
 */
import lejos.nxt.Button; 
import lejos.nxt.LCD; 
import lejos.nxt.LightSensor; 
import lejos.nxt.Motor; 
import lejos.nxt.SensorPort; 

public class Linie { 
     
     
    /* 
     * 
     * ************************************* 
     *                  VARIABLES 
     * ************************************* 
     *  
     */ 

    // robot status variables 
    private static final int ON_LINE            = 1; 
    private static final int NOT_ON_LINE        = 4; 
    private static final int LEFT               = 2;  
    private static final int RIGHT              = 3; 
    private static final int ERROR              = 99; 
     
    // menu status variables 
    private static final int SHOW_MAIN_SCREEN   = 10; 
    private static final int SHOW_INFO          = 11; 
    private static final int START_PROGRAM      = 12; 
    private static final int STOP_PROGRAM       = 13; 

    private static final int SET_OUTER_DIR      = 15; 
    private static final int SET_INNER_DIR      = 16; 
    private static final int SET_MOTORSPEED     = 18; 
    private static final int SET_LIGHT          = 19; 
     
     
    // status variable 
    private static int status                   = -1; 
     
    // engine and sensor variables 
    private static int motorSpeed               = 800; 
    private static int minLight                 = 450; 
     
    private static LightSensor sensor1; 
     
    // data variables for various actions 
    private static int old_direction            = 0; 
    private static int innerdir                 = 15; 
    private static int outerdir                 = 50; 
    private static int turningSpeed             = 100;
    
    // time in milliseconds needed to turn 1 degree at speed 10
    private static int time_at_degree           = 2;  
     
     
     
    /* 
     * 
     * ************************************* 
     *                GUI METHODS 
     * ************************************* 
     *  
     */ 
     
     
    /** 
     *  
     * Starts the user interface on the lego  
     * brick block. 
     *  
     * @throws Exception 
     *  
     */ 
    private static void startUI() throws Exception{ 
         
        status = SHOW_MAIN_SCREEN; 
        while( status != START_PROGRAM ){ 
             
            updateScreen(); 
            checkUserInput(); 
        } 
    } 
     
    /** 
     *  
     * updates screen in relationship to the status 
     *  
     * @throws Exception 
     *  
     */ 
    private static void updateScreen() throws Exception{ 
         
        switch( status ){ 
         
            // MAIN MENU 
            // 
            case SHOW_MAIN_SCREEN: 
                LCD.clear(); 
                LCD.drawString( "ENTER  : Start",1,1); 
                LCD.drawString( "RIGHT  : About",1,2); 
                LCD.drawString( "LEFT   : Params",1,3); 
                LCD.drawString( "ESCAPE : Stop",1,4); 
                break; 
                 
            // SHOW INFORMATION 
            // 
            case SHOW_INFO : 
                LCD.clear(); 
                LCD.drawString("Version : 2.0", 1, 1); 
                LCD.drawString("Created by :", 1, 3); 
                LCD.drawString("G. Miehlke", 1, 4); 
                LCD.drawString("A. Radom", 1, 5); 
                LCD.drawString("S. Kretschmann", 1, 6); 
                break; 
             
            // SET PARAMS 
            // 
            case SET_OUTER_DIR : 
                LCD.clear(); 
                LCD.drawString("Outer : "+outerdir, 1, 2); 
                break; 
             
            case SET_INNER_DIR : 
                LCD.clear(); 
                LCD.drawString("Inner : "+innerdir, 1, 2); 
                break; 
                 
            case SET_MOTORSPEED : 
                LCD.clear(); 
                LCD.drawString("Move : "+motorSpeed, 1, 2); 
                break; 

            case SET_LIGHT : 
                LCD.clear(); 
                LCD.drawString("Light : "+minLight, 1, 2); 
                break; 
                 
            // STOP PROGRAM 
            // 
            case STOP_PROGRAM : 
                LCD.clear(); 
                LCD.drawString("Good Bye =D", 4, 3); 
                Thread.sleep(2500); 
                System.exit(0); 
                break; 
        } 
    } 
     
     
    /** 
     *  
     * check the user input and set the status if necessary 
     *  
     * @throws Exception 
     *  
     */ 
    private static void checkUserInput() throws Exception{ 
         
        while( true ){ 
             
            // 
            // react on user inputs and change the status or change 
            // variables 
             
            if( Button.ENTER.isPressed() ){ 
                if( status == SHOW_MAIN_SCREEN )        { status = START_PROGRAM; break; } 
                else if( status == SET_OUTER_DIR )      { status = SET_INNER_DIR; break; } 
                else if( status == SET_INNER_DIR )      { status = SET_MOTORSPEED; break; } 
                else if( status == SET_MOTORSPEED )     { status = SET_LIGHT; break; } 
                else if( status == SET_LIGHT )          { status = SET_OUTER_DIR ; break; } 
            } 
            else if( Button.ESCAPE.isPressed() ){ 
                if( status == SHOW_MAIN_SCREEN )        { status = STOP_PROGRAM; break; } 
                else                                    { status = SHOW_MAIN_SCREEN; break; } 
            } 
            else if( Button.RIGHT.isPressed() ){ 
                if( status == SHOW_MAIN_SCREEN ){ status = SHOW_INFO; break; } 
                else if( status == SET_OUTER_DIR && outerdir < 180 ){ outerdir += 5 ; break; } 
                else if( status == SET_INNER_DIR && innerdir < 90 ){ innerdir += 5; break; } 
                else if( status == SET_MOTORSPEED && motorSpeed < 1000 ){ motorSpeed += 50; break; } 
                else if( status == SET_LIGHT && minLight < 500 ){ minLight += 5; break; } 
            } 
            else if( Button.LEFT.isPressed() ){ 
                if( status == SHOW_MAIN_SCREEN ){ status = SET_OUTER_DIR; break; } 
                else if( status == SET_OUTER_DIR && outerdir > 5 ){    outerdir -= 5; break; } 
                else if( status == SET_INNER_DIR && innerdir > 10){  innerdir -= 5; break; } 
                else if( status == SET_MOTORSPEED && motorSpeed > 50){ motorSpeed -= 50; break; } 
                else if( status == SET_LIGHT && minLight > 250 ){ minLight -= 5; break; } 
            } 
             
        } 
         
        // Wait if no button is clicked ( bug of the NXT ) 
        // 
        while( true ){ 
             
            boolean clicked = false; 
            for( Button i : Button.BUTTONS ){ 
                 
                // if one button is clicked, change it to true 
                if( i.isPressed() ) clicked = true; 
            } 
             
            // if no button is pressed, break loop  
            if( !clicked ) break; 
        } 
    } 
     
     
     
    /* 
     * 
     * ************************************* 
     *                WORK METHODS 
     * ************************************* 
     *  
     */ 
     
     
    /** 
     *  
     * start method of the Line class. 
     *  
     */ 
    public static void main(String[] args) throws Exception {  
         
        Thread.sleep(500); 
         
        // start user interface 
        startUI(); 
         
        // initialize engines and sensors 
        init(); 
         
        // start the engine loop 
        loop();  
    } 
     
     
    /** 
     *  
     * Initializes the robot machine, set ups the engines and sensors. 
     *  
     */ 
    private static void init(){ 
         
        // get variables and sensors 
        sensor1 = new LightSensor(SensorPort.S1); 

        Motor.A.regulateSpeed(true); 
        Motor.B.regulateSpeed(true); 

        time_at_degree = (int) time_at_degree*(turningSpeed); 
    } 

     
    /** 
     *  
     * The complete robot life cycle 
     *  
     * @throws Exception  
     *   
     */ 
    private static void loop() throws Exception{         

        initRobot(); 
        while( ! Button.ESCAPE.isPressed() ){ 
             
            // Print out status information on LCD 
            outputStatus(); 
     
            // check status and do action 
            switch( status ){ 
             
                // robot is on the black line 
                case ON_LINE : 
                     
                    // check position, if not on line, stop the engines 
                    if( ! isOnLine() ){ 
                         
                        stopEngines(); 
                        status = NOT_ON_LINE; 
                    } 
                    break; 
                     
                // robot is not longer on the 
                // black line 
                case NOT_ON_LINE : 
                     
                    // rotate to line and if successful, start engines again 
                    if( rotateToLine() ) initRobot(); 
                     
                    // if rotating to line fails, stop program with an error 
                    else status = ERROR; 
                     
                    break; 
                     
                // error status 
                case ERROR : 
                     
                    // draw message 
                    LCD.clear(); 
                    LCD.drawString( "!! ERROR !!", 1, 3); 
                     
                    // wait for input 
                    while( ! Button.ESCAPE.isPressed() ){ 
                        Thread.sleep(10); 
                    } 
                     
                    // exit 
                    System.exit(0); 
                    break; 
            } 
        } 
    } 
     
     
    /** 
     *  
     * Check ups the position of the robot. 
     *  
     */ 
    private static boolean isOnLine(){ 
         
        // sensor leaved the line  
        if( sensor1.getNormalizedLightValue() > minLight ) return false; 
        return true; 
    } 
     
     
     
     
     
    /* 
     *  
     * *************************************  
     *                MOTOR METHODS 
     * ************************************* 
     *  
     */ 
     
    /** 
     *  
     * Reinitialize the robot to the  
     * default status.  
     *  
     * @param motorspeed driving speed  
     */ 
    private static void initRobot(){ 
         
        setSpeed( motorSpeed ); 
        startEngines(); 
        status = ON_LINE; 
    } 
     
     
    /** 
     * Start engines to drive forwards. 
     */ 
    private static void startEngines(){ 
         
        Motor.A.forward(); 
        Motor.B.forward(); 
    } 
     
     
    /** 
     * Stops the engines. 
     */ 
    private static void stopEngines(){ 
         
        Motor.A.stop(); 
        Motor.B.stop(); 
    } 
     
     
    /** 
     * Sets the maximum speed of driving. 
     *  
     * @param speed driving speed 
     */ 
    private static void setSpeed( int speed ){ 
         
        Motor.A.setSpeed(speed); 
        Motor.B.setSpeed(speed); 
    } 
     
    /** 
     * Turn the robot right or left 
     *  
     * @param side if negative turns left , else right 
     */ 
    private static void rotate( int side ){ 
         
         
        // turn right 
        if( side >= 0 ){ 
            Motor.A.forward(); 
            Motor.B.backward(); 
        } 
         
        // turn left 
        else{ 
            Motor.B.forward(); 
            Motor.A.backward(); 
        } 
    } 
      
    /** 
     *  
     * Rotate the robot to find the line 
     * 
     */ 
    private static boolean rotateToLine() throws Exception{ 
         
        if( checkArea() ) return true; 
        return false; 
    } 
     
    /** 
     *  
     * Rotate left and right 
     *  
     */ 
    private static boolean checkArea() throws Exception{ 
         
        // rotate at the area and try to rotate at the same direction 
        // where you found the line at last search 
        // 
        // first soft left, then soft right , then hard left and last hard right 
        // 
        // stop rotating if you find the black line 
        if( old_direction == LEFT ){ 
             
            if( rotateTo(-1, innerdir  , LEFT) ) return true; 
            if( rotateTo(+1, innerdir*2  , RIGHT) ) return true; 
            if( rotateTo(-1, outerdir, LEFT)) return true; 
            if( rotateTo(+1, outerdir*2  , RIGHT) ) return true; 
        } 
        else{ 

            if( rotateTo(+1, innerdir  , RIGHT) ) return true; 
            if( rotateTo(-1, innerdir*2  , LEFT) ) return true; 
            if( rotateTo(+1, outerdir, RIGHT)) return true; 
            if( rotateTo(-1, outerdir*2  , LEFT) ) return true; 
        } 
         
        // return false if no line is found 
        return false; 
         
    } 
     
    private static boolean rotateTo( int turn , int degree , int side ) throws Exception{ 
         
        // start rotating 
        rotate(turn); 
         
        // try to find line 
        if ( rotateAndFind( degree*time_at_degree) ){  
             
            // remember the direction for next search 
            old_direction = side; 
            return true;  
        } 
         
        // stop rotating 
        stopEngines(); 
        return false; 
    } 
     
     
    /** 
     *  
     * Checks the position in relationship to  
     * the black line while the robot is rotating. 
     *  
     * @param wait_time time that is needed by the robot to rotate an angle 
     * @return line found or not ? 
     * @throws Exception  
     */ 
    private static boolean rotateAndFind( float wait_time ) throws Exception{ 
         
        // set speed down to turning speed 
        setSpeed( turningSpeed ); 
         
        // initialize variables 
        int waited = 0; 
         
        // check the line until the rotating stops 
        while( waited < wait_time ){ 

            // Accelerate while you rotate 
            if( Motor.A.getSpeed() < 280 ){ 
                Motor.A.setSpeed( Motor.A.getSpeed() + 5 ); 
                Motor.B.setSpeed( Motor.B.getSpeed() + 5 ); 
            } 
             
            // check position of robot 
            if( isOnLine() ){ 
                stopEngines(); 
                return true;                 
            } 


            // sleep a little bit 
            Thread.sleep(5); 
             
            // increase timers 
            waited += 5; 
        } 
         
        // return false if you didn't found the 
        // black line 
        return false; 
    } 
     
     
    /* 
     *  
     * ************************************* 
     *               OUTPUT METHODS 
     * ************************************* 
     *  
     */ 
     

    /** 
     *  
     * Show the current status on the LCD screen 
     *  
     */ 
    private static void outputStatus(){ 
        LCD.clear(); 
        LCD.drawString( status+" -> STATUS" ,1,3); 
    } 


}