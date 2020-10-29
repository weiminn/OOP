
public class CheckMembershipCtrl {
    private TeamDAO teamDAO;

    public CheckMembershipCtrl() {
        teamDAO = new TeamDAO();
    }

    // complete the checkMembershipDuration method here
    public int checkMembershipDuration(String studentName, String teamName){
        Team team = teamDAO.retrieve(teamName);
        if(team == null) return -1;
        
        TMSDate formed = team.getDateFormed();
        
        Student member = team.retrieve(studentName);
        if(member == null) return -1;

        TMSDate date = member.getDateJoined();
        return date.calculateDifference(formed);
    }
     
}
