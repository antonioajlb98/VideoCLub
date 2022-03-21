package model;

import enums.Status;
import java.io.Serializable;
import java.time.LocalDateTime;

public class Reservation implements Serializable {

	private static final long serialVersionUID = 1L;

    private Integer ID;
    private LocalDateTime DateReser;
    private LocalDateTime FinalDate;
    private Status status;
    private Client client;
    private Copia copia;

    public Reservation(){
        this.ID=-1;
        this.DateReser=null;
        this.FinalDate=null;
        this.status=null;
        this.client=null;
        this.copia=null;
    }

    public Reservation(Integer ID, LocalDateTime Date, LocalDateTime FinalDate, Status status,Client client,Copia copy){
        this.ID=ID;
        this.DateReser=Date;
        this.FinalDate=FinalDate;
        this.status=status;
        this.client=client;
        this.copia=copy;
    }
   
    public Integer getID() {
        return this.ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }
    public LocalDateTime getDateReser() {
        return this.DateReser;
    }

    public void setDateReser(LocalDateTime dateReser) {
        DateReser = dateReser;
    }

    public LocalDateTime getFinalDate() {
        return FinalDate;
    }

    public void setFinalDate(LocalDateTime finalDate) {
        FinalDate = finalDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Product getCopia() {
        return copia;
    }

    public void setCopia(Copia copy) {
        this.copia = copy;
    }

    public boolean equals(Object obj){
        boolean valid=false;
        if(obj!=null) {
            if(this==obj) {
                valid=true;
            }else {
                if(this.getClass()==obj.getClass()) {
                    Client tmp= (Client) obj;
                    if(this.getClass().equals(tmp.getClass())) {
                        valid=true;
                    }
                }
            }
        }
        return valid;
    }

    @Override
    public String toString() {
    	return "Reservation{" + "ID=" + ID + ", Fecha de Reserva='" + DateReser +", Fecha de Entrega='" + FinalDate +", Estado=" + status +", Cliente=" + client + ", Copia=" + copia +"]"+"\n"
                + "-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n ";
    }
}