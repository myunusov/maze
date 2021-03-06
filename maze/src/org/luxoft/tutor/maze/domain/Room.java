package org.luxoft.tutor.maze.domain;

import org.luxoft.tutor.mazeframework.domain.MapSite;
import org.luxoft.tutor.mazeframework.domain.Side;

import java.util.EnumMap;

public class Room extends MapSite {

	private Integer roomNumber;

	private EnumMap<Side, MapSite> sites = new EnumMap<>(Side.class);

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public Room(int number) {
		this.roomNumber = number;
	}

	public void enter() {
		// TODO Auto-generated method stub
	}

	public MapSite getSide(Side side) {
		return sites.get(side);
	}

	public void setSide(Side side, MapSite site) {
		sites.put(side, site);
	}
}
