package PokemonTrainer;

import java.util.ArrayList;

public class Trainer {
    String name;
    int badges;
    ArrayList<Pokemon> pokemonList = new ArrayList<Pokemon>();

    public Trainer(String name, ArrayList<Pokemon> pokemonList) {
        this.name = name;
        this.badges = 0;
        this.pokemonList = pokemonList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBadges() {
        return badges;
    }

    public void setBadges(int badges) {
        this.badges = badges;
    }

    public ArrayList<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public void setPokemonList(ArrayList<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }

    public void addToPokemonList(Pokemon pokemon) {
        this.pokemonList.add(pokemon);
    }

    public void removeFromPokemonList(String pokemonName) {
        this.pokemonList.removeIf(p -> p.getName().equals(pokemonName));
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", this.getName(), this.getBadges(), this.getPokemonList().size());
    }
}
