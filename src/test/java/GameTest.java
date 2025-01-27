import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.Game.Game;
import ru.netology.Game.NotRegisteredException;
import ru.netology.Game.Player;

public class GameTest {
    Game game = new Game();

    Player player1 = new Player(1, "Player1", 10);
    Player player2 = new Player(2, "Player2", 20);
    Player player3 = new Player(3, "Player3", 10);
    Player player4 = new Player(4, "Player4", 15);

    @Test
    public void test1() {  // первый игрок выиграл
        game.register(player2);
        game.register(player3);

        int expected = 1;
        int actual = game.round("Player2", "Player3");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test2() {  // второй игрок выиграл
        game.register(player1);
        game.register(player2);

        int expected = 2;
        int actual = game.round("Player1", "Player2");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test3() {  // ничья
        game.register(player1);
        game.register(player3);

        int expected = 0;
        int actual = game.round("Player1", "Player3");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test4() {  // первый игрок не зарегистрирован
        game.register(player3);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Player1", "Player2");
        });
    }

    @Test
    public void test5() {  // второй игрок не зарегистрирован
        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Player1", "Player3");
        });
    }

    @Test
    public void test6() {  // оба игрока не зарегистрированы
        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Player3", "Player4");
        });
    }

}
