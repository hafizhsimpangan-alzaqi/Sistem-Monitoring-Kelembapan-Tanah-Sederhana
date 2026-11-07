public class SensorKelembapan extends PerangkatIoT implements Monitoring {
    private double kelembapanTanah;
    private boolean tanahKering;

    public SensorKelembapan(String idPerangkat) {
        this(idPerangkat, 0.0);
    }

    public SensorKelembapan(String idPerangkat, double kelembapanTanah) {
        super(idPerangkat, "Sensor Kelembapan");
        setKelembapanTanah(kelembapanTanah);
        setTanahKering(kelembapanTanah < KonfigurasiIoT.BATAS_KELEMBAPAN);
    }

    public double getKelembapanTanah() {
        return kelembapanTanah;
    }

    public void setKelembapanTanah(double kelembapanTanah) {
        this.kelembapanTanah = kelembapanTanah;
    }

    public boolean isTanahKering() {
        return tanahKering;
    }

    public void setTanahKering(boolean tanahKering) {
        this.tanahKering = tanahKering;
    }

    @Override
    public void jalankan() {
        if (getKelembapanTanah() < KonfigurasiIoT.BATAS_KELEMBAPAN) {
            setTanahKering(true);
        } else {
            setTanahKering(false);
        }
    }

    @Override
    public void tampilkanData() {
        super.tampilkanInfo();

        IO.println("Kelembapan Tanah\t: " + getKelembapanTanah() + "%");

        if (isTanahKering()) {
            IO.println("Kondisi Tanah\t: Kering");
        } else {
            IO.println("Kondisi Tanah\t: Cukup Lembap");
        }
    }
}