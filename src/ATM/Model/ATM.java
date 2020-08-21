package ATM.Model;

public class ATM {
    private int[] Bills = new int[3];
    static int money;

    public ATM(){
        Bills[0] = 2;
        Bills[1] = 3;
        Bills[2] = 5;
        setMoney();
    }


    public boolean withdraw(int withdraw){
        if (withdraw <= money){
            int thou = 0;
            int fhun = 0;
            int hun = 0;
            int mon = withdraw;
            if (withdraw/1000 >= 1){
                thou = withdraw/1000;
                mon -= thou*1000;
            }
            if (mon/500 >= 1){
                fhun = mon/500;
                mon -= fhun*500;
            }
            if (mon%100==0){
                hun = mon/100;
                mon -= hun*100;
            }
            if (mon == 0){
                boolean b1 = false, b2 = false;
                if (thou <= Bills[0]){
                    b1 = true;
                    Bills[0] -= thou;
                } else if (thou != 0){
                    fhun += 2;
                }
                if (fhun <= Bills[1]){
                    b2 = true;
                    Bills[1] -= fhun;
                } else if (fhun != 0){
                    hun += 5;
                }
                if (hun <= Bills[2]){
                    Bills[2] -= hun;
                    return true;
                } else if (b1||b2){
                    if (b1){
                        Bills[0] += thou;
                    }
                    if (b2){
                        Bills[1] += fhun;
                    }
                }
            }
        }
        return false;
    }

    public void setMoney() {
        money = Bills[0]*1000+Bills[1]*500+Bills[2]*100;
    }
    public int[] getMoney() {
        setMoney();
        return new int[]{money, Bills[0], Bills[1], Bills[2]};
    }
}
