package com.militarism2.militarism2.game.unit.feature;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.militarism2.militarism2.game.map.Point;

/**
 * Класс Position описывает текущую позицию отряда,
 * конечную тучку , скорость передвижения, видиность. 
 * */

import lombok.Data;

/**
 * Класс Position описывает текущее местоположение отряда,
 * скорость, видимость, конечная точка
 * 
 * 
 * */
@Entity
@Table(name = "positions")
@Data
public class Position {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "position_Id", nullable = false, updatable = false, unique = true)
	private Long id;
	
	@OneToOne
    @JoinColumn(name="point_Id")
	@Column(name = "curent_location")
	private Point curentLocation;
	
	@OneToOne
    @JoinColumn(name="point_Id")
	@Column(name = "next_location")
	private Point nextLocation;
	
	private int speed;
	private int visibility;
	
	/**
	 * @param point -начальная точка
	 * @param speed - скорость, условно в км за одни ход
	 * @param visibility - видимость от 0 до 100 условно в процентах 
	 * */
	public Position(Point point, int speed, int visibility) {
		this.curentLocation = point;
		this.nextLocation = this.curentLocation ;
		this.speed = speed;
		this.visibility = visibility;
	}
	
	

	public Position clone() {
		return new Position(curentLocation.clone(), speed, visibility);
	}
	@Override
	public String toString() {
		return "speed:"+speed
			   +" visibility:"+visibility+"\n";
	}
}
