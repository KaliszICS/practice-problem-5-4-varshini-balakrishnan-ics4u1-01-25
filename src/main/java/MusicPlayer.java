class MusicPlayer implements Player {
    private boolean onOff;
    private String[] musicList;
    private String currentSong;
    private int volume;

    public MusicPlayer(String[] musicList) {
        this.musicList = musicList;
        this.volume = 0;
        this.onOff = false;
        this.currentSong = "";
    }
    @Override
    public void start() {
        if (this.onOff == false) {
            this.onOff = true;
            if(this.musicList.length > 0) {
                this.currentSong = this.musicList[0];
            }
        }
    }
    @Override
    public void stop() {
        if(this.onOff == true) {
            this.onOff = false;
            this.currentSong = "";
        }
    }
    public boolean getOnOff() {
        return this.onOff;
    }
    @Override
    public void volumeUp() {
        this.volume = this.volume + 1;
    }
    @Override
    public void volumeDown() {
        this.volume = this.volume - 1;
    }
    @Override
    public int getVolume() {
        return this.volume;
    }
    public void next() {
        if (this.musicList.length == 0) {
            return;
        }
        int index = 0;
        for (int i = 0; i < this.musicList.length; i++) {
            if (this.musicList[i].equals(this.currentSong)) {
                index = i;
            }
        }
        if (index < this.musicList.length - 1) {
            this.currentSong = this.musicList[index + 1];
        }
    }
    public void previous() {
        if (this.musicList.length == 0) {
            return;
        }
        int index = 0;
        for(int i = 0; i < this.musicList.length; i ++) {
            if (this.musicList[i].equals(this.currentSong)) {
                index = i;
            }
        }
        if (index > 0) {
            this.currentSong = this.musicList[index - 1];
        }
    }
    public String getCurrentSong() {
        return this.currentSong;
    }
}