/** This class represents the skills an employee posses and must have to fill a positon
 *
 */
public class EmployeeSkill {


    //todo remove production as skill
    enum Skills{
        MANAGER, PREP, MORNINGPREP, COORDINATOR, BREAKFAST, DINING, DISHES,
        CASHIER, SALAD, SANDWICH, CONSOLIDATOR, EXPEDITER, SUPPORT, PRODUCTION;
    }
    
    final Skills skill;		//holds the state of the EmployeeSkill

    /** Constructor for a given case of Skills
     * 
     * @param skill
     */
    public EmployeeSkill(Skills skill){
        this.skill = skill;
    }

    /** Constructor 
     * 
     * @param skill
     */
    public EmployeeSkill(String skill){
    	    this.skill = Skills.valueOf(skill);
    }

    /** Returns whether or not the EmployeeSkill objects have the same value
     * Used to match a position with a skill
     *
     * @param aSkill
     * @return true if the skills match, false if otherwise
     */
    @Override
    public boolean equals(Object aSkill){
    	if (aSkill instanceof EmployeeSkill){
    		EmployeeSkill that = (EmployeeSkill)aSkill;
    		return this.skill == that.skill;
    	}
    	else
    		return false;
    }
    
    public String toString(){
    	return skill.name();
    }

/*
    public static void main(String[] args){

        EmployeeSkill skill1 = new EmployeeSkill(Skills.PREP);
        EmployeeSkill skill2 = new EmployeeSkill(Skills.PREP);
        EmployeeSkill skill3 = new EmployeeSkill("PREP");


        //System.out.println(skill1.equals(1));
        System.out.println(skill1.equals((Skills.PREP)));
        System.out.println(skill1.equals(skill1));
        System.out.println(skill1.equals(new EmployeeSkill(Skills.PREP)));
        System.out.println(skill1.equals(skill2));
        System.out.println(skill1.equals(skill3));
        System.out.println(skill1);


        EmployeeSkill skill4 = new EmployeeSkill(skill1.toString());
        System.out.println(skill1.equals(skill4));
        System.out.println(skill4);

    }
    */
}
