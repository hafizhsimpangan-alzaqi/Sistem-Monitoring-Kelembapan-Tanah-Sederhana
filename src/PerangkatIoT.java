public abstract class PerangkatIoT {

    private final String idPerangkat;
    private String namaPerangkat;

    public PerangkatIoT(String idPerangkat, String namaPerangkat) {
        this.idPerangkat = idPerangkat;
        this.namaPerangkat = namaPerangkat;
    }

    public String getIdPerangkat() {
        return idPerangkat;
    }

    public String getNamaPerangkat() {
        return namaPerangkat;
    }

    public void setNamaPerangkat(String namaPerangkat) {
        this.namaPerangkat = namaPerangkat;
    }

    public void tampilkanInfo() {
        IO.println("ID Perangkat\t: " + getIdPerangkat());
        IO.println("Nama Perangkat\t: " + getNamaPerangkat());
    }

    public abstract void jalankan();
}