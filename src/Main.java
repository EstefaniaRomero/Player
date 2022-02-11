import java.security.spec.RSAOtherPrimeInfo;
import java.util.ArrayList;

import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Player> players = buildPlayersList();
        Player playerMaxPoints = getPlayerMaxPoints(players);

        System.out.println("El Jugador con más puntos es: " + playerMaxPoints);

        System.out.println("La media de los puntos es: " + calculateAVGPoints(players));
        String team = "BOET";

        double avg = calculateAvgPointsByTeam(players,team);

        System.out.println("El avg de los puntos de los" +
                " jugadores del equipo " + team + " es " + avg);

        List<Player> top5 = getTop5MaxPoints(players);

        System.out.println("El Top 5 de los jugadores con más canastas son: " + '\n' + top5);


    }

    private static List<Player> buildPlayersList() {
        List<Player> players = new ArrayList<>();

        Player rocio = new Player("Rocío", 79, "ABPREMIA");
        Player xavi = new Player("Xavi", 46, "BOET");
        Player sergi = new Player("Sergi", 54, "BOET");
        Player olga = new Player("Olga", 93, "ABPREMIA");
        Player rosario = new Player("Rosario", 78, "BOET");
        Player gerard = new Player("Gerard", 99, "ABPREMIA");

        players.add(rocio);
        players.add(xavi);
        players.add(sergi);
        players.add(olga);
        players.add(rosario);
        players.add(gerard);

        return players;


    }

    private static List<Player> getTop5MaxPoints(List<Player> players) {
        return players.stream()
        .sorted(Comparator.comparing(Player::getNumPoints).reversed())
        .toList();

    }

    private static Player getPlayerMaxPoints(List<Player> players) {

        Player playerMaxPoints = players.get(0);

        for (int i = 0; i < players.size(); i++) {
            Player currentPlayer = players.get(i);
            if (currentPlayer.getNumPoints() > playerMaxPoints.getNumPoints()) {
                playerMaxPoints = currentPlayer;
            }
        }

//        for (Player currentPlayer : players ) {
//            if(currentPlayer.getNumPoints() > playerMaxPoints.getNumPoints()){
//                playerMaxPoints = currentPlayer;
//            }
//        }

//        return players.stream()
//                .max(comparing(Player::getNumPoints))
//                .get();


        return playerMaxPoints;
    }

    private static double calculateAVGPoints(List<Player> players) {
        return players.stream()
                .mapToInt(Player::getNumPoints)
                .average()
                .getAsDouble();

    }


    private static double calculateAvgPointsByTeam (List<Player> players, String team) {

        //1. Creo un ArrayList auxiliar vacio
        List<Player> playersFromTeam = new ArrayList<>();

        //2. Agrupar los jugadores de un equipo en particular en
        //ArrayList auxiliar (ejemplo BOET)
        for (Player currentPlayer : players) {
            if (currentPlayer.getTeam().equalsIgnoreCase(team)) {
                playersFromTeam.add(currentPlayer);
            }
        }

        //3. Calcular AVG de puntos de los
        // jugadores del ArrayList auxiliar (ejemplo BOET)
        double totalPoints = 0;

        for (int i = 0; i < playersFromTeam.size(); i++) {
            Player currentPlayer = playersFromTeam.get(i);
            totalPoints = totalPoints + currentPlayer.getNumPoints();
        }

        double avg = totalPoints / playersFromTeam.size();

        return avg;
    }
}