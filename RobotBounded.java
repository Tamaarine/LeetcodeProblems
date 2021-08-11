public class RobotBounded
{
    public static void main(String[] args)
    {
        System.out.println(isRobotBounded("GGLLGG"));
        System.out.println(isRobotBounded("GG"));
        System.out.println(isRobotBounded("GL"));

    }
    
    public static boolean isRobotBounded(String instructions)
    {
        int displacement[] = {0,0};
        
        // 0 = North
        // 1 = East
        // 2 = South
        // 3 = West
        int direction = 0;
        
        // First pass for calculating the displacement
        direction = isRobotHelper(instructions, direction, displacement);
        
        // It stayed in a circle if the displacement is 0 after first pass
        if(displacement[0] == 0 && displacement[1] == 0)
        {
            return true;
        }
        
        // If after the first pass the displacement vector is not 0 then
        // we have to do a second pass to check if the displacement vector changes
        // direction if it does then that means it will be bound in a circle
        int secondDirection = isRobotHelper(instructions, direction, displacement);
        
        if(secondDirection != direction)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public static int isRobotHelper(String instructions, int direction, int displacement[])
    {
        for(int i=0;i<instructions.length();i++)
        {
            char currentInstruction = instructions.charAt(i);
            
            if(currentInstruction == 'G')
            {
                switch(direction)
                {
                    case 0:
                        displacement[1] += 1;
                        break;
                    case 1:
                        displacement[0] += 1;
                        break;
                    case 2:
                        displacement[1] -= 1;
                        break;
                    case 3:
                        displacement[0] -= 1;
                }
            }
            else if(currentInstruction == 'L')
            {
                if(direction == 0)
                {
                    direction = 3;
                }
                else
                {
                    direction--;
                }
            }
            else if(currentInstruction == 'R')
            {
                if(direction == 3)
                {
                    direction = 0;
                }
                else
                {
                    direction++;
                }
            }
        }
        
        return direction;
    }
}
