package com.example.fsp.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "airlines")
public class Airline {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;

		@Column(name = "airline_name")
		private String airlineName;

		@Column(name = "Source")
		private String Source;

		@Column(name = "airline_id")
		private String airlineId;
		
		@Column(name = "destination")
		private String destination;
		 
		@Column(name="seating capacity")
		private int seatingcapacity;
		
		@Column(name="Cost")
		private int cost;
		
        // default constructor
		public Airline() {

		}

		//parameterized constructor
		public Airline(String airlineName, String Source, String airlineId) {
			super();
			this.airlineName = airlineName;
			this.Source = Source;
			this.airlineId = airlineId;
		}
		
		// getters and setters
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getAirlineName() {
			return airlineName;
		}
		public void setAirlineName(String airlineName) {
			this.airlineName = airlineName;
		}
		public String getSource() {
			return Source;
		}
		public void setSource(String Source) {
			this.Source = Source;
		}
		public String getAirlineId() {
			return airlineId;
		}
		public void setAirlineId(String airlineId) {
			this.airlineId = airlineId;
		}
		public String getdestination() {
			return destination;
		}
		public void setdestination(String destination) {
			this.destination = destination;
		}	
		public int getseatingcapacity() {
			return seatingcapacity;
		}
		public void setseatingcapacity(int seatingcapacity) {
			this.seatingcapacity = seatingcapacity;
		}
		public int cost() {
			return cost;
		}
		public void setcost(int cost) {
			this.cost = cost;
		}
			
	}


