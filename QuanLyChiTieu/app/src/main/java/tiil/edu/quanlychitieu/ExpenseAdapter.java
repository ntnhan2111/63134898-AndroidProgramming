package tiil.edu.quanlychitieu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExpenseAdapter
        extends RecyclerView.Adapter<
        ExpenseAdapter.ViewHolder> {

    ArrayList<Expense> list;

    public ExpenseAdapter(
            ArrayList<Expense> list) {

        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent,
            int viewType) {

        View view =
                LayoutInflater.from(parent.getContext())
                        .inflate(
                                R.layout.item_expense,
                                parent,
                                false
                        );

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            @NonNull ViewHolder holder,
            int position) {

        Expense expense = list.get(position);

        holder.txtName.setText(
                expense.getName());

        holder.txtMoney.setText(
                "Số tiền: "
                        + expense.getMoney()
                        + " VNĐ");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder
            extends RecyclerView.ViewHolder {

        TextView txtName, txtMoney;

        public ViewHolder(
                @NonNull View itemView) {

            super(itemView);

            txtName =
                    itemView.findViewById(
                            R.id.txtName);

            txtMoney =
                    itemView.findViewById(
                            R.id.txtMoney);
        }
    }
}