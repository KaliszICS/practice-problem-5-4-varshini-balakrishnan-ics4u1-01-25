class RadioPlayer implements Player {
    private boolean onOff;
    private double[] stationList;
    private int volume;
    private double station;

    public RadioPlayer(double[] stationList) {
        this.stationList = stationList;
        this.volume = 0;
        this.onOff = false;
        this.station = 0.0;
    }
    @Override
    public void start() {
        if (this.onOff == false) {
            this.onOff = true;
            if(this.stationList.length > 0) {
                this.station = this.stationList[0];
            }
        }
    }
    @Override
    public void stop() {
        if(this.onOff == true) {
            this.onOff = false;
            this.station = 0.0;
        }
    }
    public boolean getOnOff() {
        return this.onOff;
    }
    @Override
    public void volumeUp() {
        this.volume = this.volume + 2;
    }
    @Override
    public void volumeDown() {
        this.volume = this.volume - 2;
    }
    @Override
    public int getVolume() {
        return this.volume;
    }
    public void next() {
        if (this.stationList.length == 0) {
            return;
        }
        int index = 0;
        for (int i = 0; i < this.stationList.length; i++) {
            if (this.stationList[i] == this.station) {
                index = i;
            }
        }
        if (index < this.stationList.length - 1) {
            this.station = this.stationList[index + 1];
        }
    }   
    public void previous() {
        if (this.stationList.length == 0) {
            return;
        }
        int index = 0;
        for(int i = 0; i < this.stationList.length; i ++) {
            if (this.stationList[i] == this.station) {
                index = i;
            }
        }
        if (index > 0) {
            this.station = this.stationList[index - 1];
        }
    }
    public double getStation() {
        return this.station;
    }  
}