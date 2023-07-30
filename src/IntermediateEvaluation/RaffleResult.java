package IntermediateEvaluation;

import java.time.LocalDateTime;

public class RaffleResult {
    private LocalDateTime dateTime;
    private String prizeName;
    private int receiptNumber;
    private boolean won; // Флаг, указывающий, выиграл ли пользователь призовую игрушку


    public RaffleResult(boolean won, LocalDateTime dateTime, String prizeName, int receiptNumber) {
        this.dateTime = dateTime;
        this.prizeName = prizeName;
        this.receiptNumber = receiptNumber;
        this.won = won;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getPrizeName() {
        return prizeName;
    }

    public int getReceiptNumber() {
        return receiptNumber;
    }

    public boolean isWon() {
        return won;
    }
}

