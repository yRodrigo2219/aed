public class Main{
    public static void main(String[] args) {
        Hashing a = new Hashing(367);

        for(int i = 1; i <= 12; i++){
            for(int j = 1; j <= 31; j++){
                if(i == 2){
                    if(j < 10){
                        a.add("0"+j+"/"+"0"+i);
                    }else if(j <= 29){
                        a.add(j+"/"+"0"+i);
                    }
                }else if(i % 2 == 0 && i < 10){
                    if(j < 10){
                        a.add("0"+j+"/"+"0"+i);
                    }else if(j <= 30){
                        a.add(j+"/"+"0"+i);
                    }
                }else if(i < 10){
                    if(j < 10){
                        a.add("0"+j+"/"+"0"+i);
                    }else{
                        a.add(j+"/"+"0"+i);
                    }
                }else if(i % 2 == 0){
                    if(j < 10){
                        a.add("0"+j+"/"+i);
                    }else if(j <= 30){
                        a.add(j+"/"+i);
                    }
                }else{
                    if(j < 10){
                        a.add("0"+j+"/"+i);
                    }else{
                        a.add(j+"/"+i);
                    }
                }
            }
        }

        System.out.println(a);
    }
}