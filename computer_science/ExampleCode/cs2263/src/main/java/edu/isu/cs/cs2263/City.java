package edu.isu.cs.cs2263;

public class City implements Comparable<City> {

    private String name;
    private State state;
    private int population;

    public City(String name, State state, int population) {
        this.name = name;
        this.state = state;
        this.population = population;
    }

    public int compareTo(City city) {
//        int result;
//        if ((result = name.compareTo(city.name)) == 0)
//            return state.compareTo(city.state);
//        return result;
        return Integer.compare(this.population, city.population);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof City) {
            City city = (City) obj;
            return compareTo(city) == 0;
        }
        return false;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("City{");
        sb.append("name='").append(name).append('\'');
        sb.append(", state=").append(state);
        sb.append(", population=").append(population);
        sb.append('}');
        return sb.toString();
    }
}
