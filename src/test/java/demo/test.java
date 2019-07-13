package demo;

import com.google.appengine.repackaged.com.google.gson.Gson;

import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
      Game game = new Game();
      game.setName("Lol");
      game.setDescrip("Hellpo");

      Game game1 = new Game();
      game1.setName("Lien quan");
      game1.setDescrip("aa");

      ArrayList<Game> gameArrayList = new ArrayList<>();
      gameArrayList.add(game);
      gameArrayList.add(game1);

      JsonHandle jsonHandle = new JsonHandle();
      jsonHandle.setValues(201,"Mesage",gameArrayList);
        System.out.println(new Gson().toJson(jsonHandle));

    }
}
