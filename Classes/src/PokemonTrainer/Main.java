package PokemonTrainer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        ArrayList<Trainer> trainers = new ArrayList<Trainer>();

        while (!line.equals("Tournament")) {
            String[] tokens = line.split(" ");
            String name = tokens[0];
            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);
            Trainer trainer = null;
            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            if (trainers.stream().noneMatch(t -> t.getName().equals(name))) {
                trainer = new Trainer(name, new ArrayList<Pokemon>());
                trainers.add(trainer);
            } else {
                trainer = trainers.stream()
                        .filter(t -> t.getName().equals(name))
                        .collect(Collectors.toList())
                        .get(0);
            }
            trainer.addToPokemonList(pokemon);

            line = scanner.nextLine();
        }
        line = scanner.nextLine();

        while (!line.equals("End")) {
            String element = line;
            for (Trainer trainer : trainers) {
                if (trainer.getPokemonList().stream().anyMatch(p -> p.getElement().equals(element))) {
                    trainer.setBadges(trainer.getBadges() + 1);
                } else {
                    ArrayList<Pokemon> updatedPokemon = trainer.getPokemonList();
                    for (Pokemon pokemon : updatedPokemon) {
                        pokemon.setHealth(pokemon.getHealth() - 10);
                        if (pokemon.getHealth() <= 0) {
                            trainer.removeFromPokemonList(pokemon.getName());
                            break;
                        }
                    }
                }

            }
            line = scanner.nextLine();
        }
        for (Trainer trainer : trainers.stream()
                .sorted((t1, t2) -> Integer
                        .compare(t2.getBadges(), t1.getBadges()))
                .collect(Collectors.toList())) {
            System.out.println(trainer.toString());
        }
    }
}
