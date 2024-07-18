package com.cse260.lease.web.app.vo.fee;


import com.cse260.lease.model.entity.FeeKey;
import com.cse260.lease.model.entity.FeeValue;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;


@Data
public class FeeKeyVo extends FeeKey {

    @Schema(description = "杂费value列表")
    private List<FeeValue> feeValueList;
}
