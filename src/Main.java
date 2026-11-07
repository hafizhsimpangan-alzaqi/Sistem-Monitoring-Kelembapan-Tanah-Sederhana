public class Main {

    void main() {
        try {
            SensorKelembapan sensor = new SensorKelembapan("S001");
            PompaAir pompa = new PompaAir("P001", sensor);

            sensor.setNamaPerangkat("Sensor Kelembapan Tanah");
            pompa.setNamaPerangkat("Pompa Penyiraman Otomatis");

            IO.println("================================");
            IO.println("        PlantCare System IoT");
            IO.println("  Monitoring Kelembapan Tanah");
            IO.println("================================");

            String inputKelembapan = IO.readln("Masukkan kelembapan tanah (%): ");
            double kelembapan = Double.parseDouble(inputKelembapan);

            if (!Double.isFinite(kelembapan) || kelembapan < 0 || kelembapan > 100) {
                IO.println("Presentase kelembapan harus antara 0 dan 100.");
                return;
            }

            sensor.setKelembapanTanah(kelembapan);
            sensor.jalankan();
            pompa.jalankan();

            Monitoring monitoringSensor = sensor;
            Monitoring monitoringPompa = pompa;

            IO.println("\n========== DATA SENSOR ==========");
            monitoringSensor.tampilkanData();

            IO.println("\n========== DATA POMPA ==========");
            monitoringPompa.tampilkanData();

            IO.println("================================");
            IO.println("       Monitoring Selesai");
            IO.println("================================");

        } catch (NumberFormatException e) {
            IO.println("Input tidak valid! Masukkan kelembapan dalam bentuk angka.");
        }
    }
}
