public class PompaAir extends PerangkatIoT implements Monitoring, Pengendalian {

    private SensorKelembapan sensorKelembapan;
    private boolean statusPompa;

    public PompaAir(String idPerangkat, SensorKelembapan sensorKelembapan) {
        super(idPerangkat, "Pompa Air");
        setSensorKelembapan(sensorKelembapan);
        setStatusPompa(false);
    }

    public SensorKelembapan getSensorKelembapan() {
        return sensorKelembapan;
    }

    public void setSensorKelembapan(SensorKelembapan sensorKelembapan) {
        this.sensorKelembapan = sensorKelembapan;
    }

    public boolean getStatusPompa() {
        return statusPompa;
    }

    public void setStatusPompa(boolean statusPompa) {
        this.statusPompa = statusPompa;
    }

    @Override
    public void nyalakan() {
        setStatusPompa(true);
    }

    @Override
    public void matikan() {
        setStatusPompa(false);
    }

    @Override
    public void jalankan() {
        if (getSensorKelembapan().isTanahKering()) {
            nyalakan();
        } else {
            matikan();
        }
    }

    @Override
    public void tampilkanData() {
        super.tampilkanInfo();

        if (getStatusPompa()) {
            IO.println("Status Pompa\t: ON");
        } else {
            IO.println("Status Pompa\t: OFF");
        }
    }
}
