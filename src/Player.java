import java.util.Objects;

public class Player {

    private String name;
    private int numPoints;
    private String team;

    public Player(String name, int numPoints, String team) {
        this.name = name;
        this.numPoints = numPoints;
        this.team = team;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumPoints() {
        return numPoints;
    }

    public void setNumPoints(int numPoints) {
        this.numPoints = numPoints;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", numPoints=" + numPoints +
                ", team='" + team + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

}
