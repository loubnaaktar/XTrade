public class Portfolio <Asset>{
Asset A;
int idPorfolio;
static int count = 100;


    public Portfolio(){
        this.idPorfolio = count;
        count++;
    }
    public int getIdPorfolio() {
        return idPorfolio;
    }

    public void setIdPorfolio(int idPorfolio) {
        this.idPorfolio = idPorfolio;
    }

}
