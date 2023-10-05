package io.ulpgc;

import java.util.*;

import static io.ulpgc.Kata.Move.*;
import static java.lang.Math.max;
import static java.lang.Math.min;

public class Kata {

	final static Map<Coordinate, String> players;

	public static void main(String[] args) {
		Coordinate coordinate = new Coordinate(0, 0);
		Move[] moves = {up, down,left, right};

		List<String> result = new ArrayList<>();
		for (Move move : moves) {
			coordinate = coordinate.move(move);
			result.add(players.get(coordinate));
		}
		for (String s : result) {
			System.out.println(s);
		}
	}


	static {
		players = new HashMap<>();
		players.put(new Coordinate(0,0), "a");
		players.put(new Coordinate(1,0), "b");
		players.put(new Coordinate(2,0), "c");
		players.put(new Coordinate(3,0), "d");
		players.put(new Coordinate(4,0), "e");
		players.put(new Coordinate(5,0), "f");
		players.put(new Coordinate(0,1), "g");
		players.put(new Coordinate(1,1), "h");
		players.put(new Coordinate(2,1), "i");
		players.put(new Coordinate(3,1), "j");
		players.put(new Coordinate(4,1), "k");
		players.put(new Coordinate(5,1), "l");
	}



	public static class Coordinate {
		final static Map<Move, Coordinate> moves;
		final static int max_x = 6;
		final static int max_y = 2;
		final int x;
		final int y;

		public Coordinate(int x, int y) {
			this.x = (x + max_x) % max_x;
			this.y = max(min(y, max_y),0);
		}

		public Coordinate move(Move move) {
			return new Coordinate(x+moves.get(move).x, y+moves.get(move).y);
		}

		@Override
		public int hashCode() {
			return y*max_x+x;
		}

		@Override
		public boolean equals(Object object) {
			if (this == object) return true;
			if (object == null || getClass() != object.getClass()) return false;
			Coordinate that = (Coordinate) object;
			return x == that.x && y == that.y;
		}

		static {
			moves = new HashMap<>();
			moves.put(up, new Coordinate(0,-1));
			moves.put(down, new Coordinate(0,1));
			moves.put(left, new Coordinate(-1,0));
			moves.put(right, new Coordinate(1,0));
		}


	}

	public enum Move {
		up, down, left, right
	}

}
